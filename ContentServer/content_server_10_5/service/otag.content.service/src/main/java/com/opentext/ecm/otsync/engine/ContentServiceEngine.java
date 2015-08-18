package com.opentext.ecm.otsync.engine;

import com.opentext.ecm.otsync.ContentServiceConstants;
import com.opentext.ecm.otsync.SettingsService;
import com.opentext.ecm.otsync.engine.core.SuspendedActionQueue;
import com.opentext.ecm.otsync.http.HTTPRequestManager;
import com.opentext.ecm.otsync.listeners.*;
import com.opentext.ecm.otsync.message.Message;
import com.opentext.ecm.otsync.ws.ServletUtil;
import com.opentext.ecm.otsync.ws.message.JsonMessageConverter;
import com.opentext.ecm.otsync.ws.message.MessageConverter;
import com.opentext.ecm.otsync.ws.server.CleanUpThread;
import com.opentext.ecm.otsync.ws.server.ClientSet;
import com.opentext.ecm.otsync.ws.server.servlet3.Servlet3BackChannel;
import com.opentext.ecm.otsync.ws.server.servlet3.Servlet3ChunkedContentChannel;
import com.opentext.ecm.otsync.ws.server.servlet3.Servlet3ContentChannel;
import com.opentext.ecm.otsync.ws.server.servlet3.Servlet3FrontChannel;
import com.opentext.otag.api.services.client.IdentityServiceClient;
import com.opentext.otag.api.services.client.NotificationsClient;
import com.opentext.otag.api.services.handlers.AbstractSettingChangeHandler;
import com.opentext.otag.api.shared.types.message.SettingsChangeMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The engine:
 * <p>
 * Create message feeds with thread pools. There is one main (shared) pool that will handle all
 * requests headed for content server(external user api calls excepted). In addition, there are
 * separate queues with a small number of dedicated threads for uploads, downloads, and front-channel
 * operations. Each action should be enqueued in the shared pool as well as the appropriate dedicated
 * pool; the suspended action queues will ensure the action is only processed once, by the first
 * available thread in  either pool.
 */
public class ContentServiceEngine {

    public static Log LOG = LogFactory.getLog(ContentServiceEngine.class);

    /**
     * Listens for changes to the CS sync threads - setting desc - Maximum number of Content
     * Server threads to use for automated sync actions. Updating the number of threads
     * available in our engines main Thread pool. Will get instantiated by the Appworks platform.
     */
    @SuppressWarnings("unused")
    public static class ThreadMaxSettingListener extends AbstractSettingChangeHandler {

        @Override
        public String getSettingKey() {
            return ContentServiceConstants.CS_SYNCTHREADS_MAX;
        }

        @Override
        public void onSettingChanged(SettingsChangeMessage message) {
            int threadCount;
            try {
                threadCount = Integer.parseInt(message.getNewValue());
                sharedThreadPool.setThreads(threadCount);
            } catch (NumberFormatException e) {
                LOG.error("Failed to respond to ");
            }
        }

    }

    /**
     * Main ThreadPool, we wrap an Executor and feed it the {@code SuspendedAction} instances
     * we create in response to incoming requests.
     */
    private static SuspendedActionQueue sharedThreadPool;

    private SynchronousMessageSwitch messageHandler;

    private CleanUpThread cleanUpThread;
    private MessageConverter messageConverter;
    private HTTPRequestManager serverConnection;
    private ChunkedContentRequestQueue chunkedContentRequestQueue;

    // Connected clients
    private ClientSet clients;

    // Channels
    private Servlet3BackChannel backChannel;
    private Servlet3FrontChannel frontChannel;
    private Servlet3ContentChannel contentChannel;
    private Servlet3ChunkedContentChannel chunkedContentChannel;

    // Gateway clients
    private SettingsService settingsService;
    private NotificationsClient notificationsClient;
    private IdentityServiceClient identityServiceClient;

    public ContentServiceEngine(SettingsService settingsService,
                                NotificationsClient notificationsClient,
                                IdentityServiceClient identityServiceClient,
                                HTTPRequestManager httpRequestManager) {
        LOG.info("Initialising engine");
        this.settingsService = settingsService;
        this.notificationsClient = notificationsClient;
        this.identityServiceClient = identityServiceClient;

        messageConverter = new JsonMessageConverter();
        clients = new ClientSet();
        serverConnection = httpRequestManager;
        sharedThreadPool = SuspendedActionQueue.getThreadPool(
                settingsService.getSharedThreadPoolSize(), "mainQueue-");

        try {
            // chunked uploads and downloads use the same thread pools as regular uploads and downloads
            chunkedContentRequestQueue = new ChunkedContentRequestQueue(
                    serverConnection, messageConverter, sharedThreadPool, settingsService);
            LOG.debug("ChunkedContentRequestQueue initialised");
        } catch (ServletException e) {
            throw new RuntimeException("Failed to create ChunkedContentRequestQueue, " + e.getMessage(), e);
        }

        initListeners();

        sharedThreadPool.start();

        // start a thread to periodically discard inactive clients
        cleanUpThread = new CleanUpThread(clients, chunkedContentRequestQueue);
        cleanUpThread.start();

        // initialise channels
        initialiseChannels();
    }

    public Servlet3ChunkedContentChannel getChunkedContentChannel() {
        return chunkedContentChannel;
    }

    public Servlet3ContentChannel getContentChannel() {
        return contentChannel;
    }

    public Servlet3FrontChannel getFrontChannel() {
        return frontChannel;
    }

    public Servlet3BackChannel getBackChannel() {
        return backChannel;
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            if (ServletUtil.isFrontChannelRequest(request)) {
                frontChannel.handle(request);
            } else if (ServletUtil.isBackChannelRequest(request)) {
                backChannel.handle(request, response);
            } else if (ServletUtil.isContentChannelRequest(request)) {
                contentChannel.handle(request, response);
            } else if (ServletUtil.isChunkedContentChannelRequest(request)) {
                chunkedContentChannel.handle(request, response);
            }
        } catch (Throwable te) {
            LOG.error(te);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "OTSyncServer Reported Error:" + te.getClass().getSimpleName());
        }

    }

    private void initialiseChannels() {
        frontChannel = new Servlet3FrontChannel(sharedThreadPool, messageConverter, messageHandler, settingsService);
        LOG.info("Initialised Front Channel successfully");
        contentChannel = new Servlet3ContentChannel(serverConnection, sharedThreadPool, settingsService);
        LOG.info("Initialised Content Channel successfully");
        chunkedContentChannel = new Servlet3ChunkedContentChannel(chunkedContentRequestQueue);
        LOG.info("Initialised Chunked Content Channel successfully");
        backChannel = new Servlet3BackChannel(messageConverter, identityServiceClient, serverConnection);
        LOG.info("Initialised Back Channel successfully");

    }

    private void initListeners() {
        LOG.info("Setting up Front Channel Listeners");
        // Create a switch which will respond on the {"type"} key in the JSON string.
        // For example, the AuthMessageListener's "onMessage" method will be called when a
        // JSON string with {"type": "auth"} is POSTed to the FrontChannel
        messageHandler = new SynchronousMessageSwitch();

        AuthMessageListener authListener = new AuthMessageListener(messageConverter, serverConnection);
        messageHandler.setHandler(authListener, Message.AUTH_KEY_VALUE);

        ForwardingMessageListener notifyListener =
                new ForwardingMessageListener(
                        new NotifyMessageListener(serverConnection, notificationsClient), clients);
        messageHandler.setHandler(notifyListener, Message.NOTIFY_KEY_VALUE);

        ForwardingMessageListener pulseListener =
                new ForwardingMessageListener(new PulseMessageListener(serverConnection), clients);
        messageHandler.setHandler(pulseListener, Message.PULSE_KEY_VALUE);

        ServerCheckListener serverCheckListener = new ServerCheckListener();
        messageHandler.setHandler(serverCheckListener, Message.SERVER_CHECK_KEY_VALUE);

        ChunkedContentRequestListener chunkedContentRequestListener =
                new ChunkedContentRequestListener(chunkedContentRequestQueue);
        messageHandler.setHandler(chunkedContentRequestListener, Message.CHUNKED_CONTENT_KEY_VALUE);

        ContentRequestListener contentRequestListener = new ContentRequestListener(notificationsClient);
        messageHandler.setHandler(contentRequestListener, Message.CONTENT_KEY_VALUE);
        LOG.info("Completed Channel Listener initialisation");
    }

    public void shutdown() {
        sharedThreadPool.stop();
        cleanUpThread.stopThread();
        LOG.info("Shutdown ContentServiceEngine complete");
    }

}
