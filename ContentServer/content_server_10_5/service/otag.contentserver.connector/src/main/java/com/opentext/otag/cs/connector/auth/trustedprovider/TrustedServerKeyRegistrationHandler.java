package com.opentext.otag.cs.connector.auth.trustedprovider;

import com.opentext.otag.api.services.client.TrustedProviderClient;
import com.opentext.otag.api.services.handlers.AppworksServiceContextHandler;
import com.opentext.otag.api.shared.types.TrustedProvider;
import com.opentext.otag.api.shared.types.sdk.AppworksComponentContext;
import com.opentext.otag.cs.connector.ContentServerConnector;
import com.opentext.otag.cs.connector.auth.registration.AuthRegistrationHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This class is responsible for registering the Trusted Provider key
 * generated by the Gateway for Content Server. It wraps a thread that
 * will attempt the registration, we might not be able to register right
 * away as we need CS auth to be setup to do the registration.
 * <p>
 * As it is an {@code AppworksServiceContextHandler} implementation it will
 * be informed when the service is started and stopped.
 *
 * @see ContentServerConnector#registerTrustedServerKey(String, String)
 */
public class TrustedServerKeyRegistrationHandler implements AppworksServiceContextHandler {

    private static final Log LOG = LogFactory.getLog(TrustedServerKeyRegistrationHandler.class);

    private RegisterKeyThread registerKeyThread;

    /**
     * Fire up the key registration Thread onStart.
     *
     * @param appName name of this app/service
     */
    @Override
    public void onStart(String appName) {
        LOG.info("Starting Trusted Provider Key registration");
        TrustedProviderClient providerClient = new TrustedProviderClient(appName);
        registerKeyThread = new RegisterKeyThread(providerClient);
        registerKeyThread.start();
    }

    @Override
    public void onStop(String appName) {
        if (registerKeyThread != null && registerKeyThread.isAlive())
            registerKeyThread.shutdown();
    }

    /**
     * Thread class that retrieves/creates the TrustedProvider key and
     * attempts the registration.
     */
    private static class RegisterKeyThread extends Thread {

        /**
         * The connector know how to perform the registration.
         */
        private ContentServerConnector connector;

        /**
         * The reg handler knows when we can use CS auth.
         */
        private AuthRegistrationHandler authRegistrationHandler;

        private String trustedServerKey;
        private String trustedServerName;

        private boolean keepRunning = true;

        public RegisterKeyThread(TrustedProviderClient providerClient) {
            super("Register Trusted Provider Key Thread");
            connector = AppworksComponentContext.getComponent(ContentServerConnector.class);
            authRegistrationHandler = AppworksComponentContext.getComponent(AuthRegistrationHandler.class);

            if (connector == null)
                throw new IllegalStateException("Unable to resolve connector via the AppworksComponentContext");

            TrustedProvider provider = providerClient.getOrCreate(connector.getTrustedServerName());

            if (provider == null)
                throw new RuntimeException("Failed to retrieve/create Trusted Provider Key");

            trustedServerKey = provider.getKey();
            trustedServerName = connector.getTrustedServerName();
        }

        @Override
        public void run() {
            LOG.info("Started Trusted Server Key registration Thread");

            while (keepRunning) {
                if (authRegistered()) {
                    LOG.info("Detected CS Auth Handler has been registered attempted to contact " +
                            "Content Server with Trusted provider key");
                    if (connector.registerTrustedServerKey(trustedServerName, trustedServerKey)) {
                        keepRunning = false;
                        LOG.info("Registered Trusted Provider key with Gateway");
                    } else {
                        LOG.info("Attempted registration of Trusted Provider key failed, sleeping ...");
                        sleep();
                    }
                } else {
                    LOG.info("ContentServerAuthHandler is yet to be registered so we cannot " +
                            "get an LLCookie to register our Trusted Provider key, sleeping ... ");
                    sleep();
                }
            }
        }

        private boolean authRegistered() {
            if (authRegistrationHandler != null)
                return authRegistrationHandler.isAuthRegistered();

            authRegistrationHandler = AppworksComponentContext.getComponent(AuthRegistrationHandler.class);
            return authRegistrationHandler != null && authRegistrationHandler.isAuthRegistered();
        }

        public void shutdown() {
            try {
                LOG.info("Shutting down " + this.getName());
                keepRunning = false;
                this.interrupt();
            } catch (Exception e) {
                LOG.error("Shutdown for " + this.getName() + " did not complete " +
                        "successfully, " + e.getMessage(), e);
            }
        }

        private void sleep() {
            try {
                Thread.sleep(20 * 1000);
            } catch (InterruptedException ignored) {
            }
        }

    }

}
