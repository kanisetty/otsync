package com.opentext.otsync.connector.auth.trustedprovider;

import com.opentext.otag.sdk.client.v3.TrustedProviderClient;
import com.opentext.otag.sdk.handlers.AWServiceContextHandler;
import com.opentext.otag.sdk.handlers.AbstractMultiSettingChangeHandler;
import com.opentext.otag.sdk.types.v3.TrustedProvider;
import com.opentext.otag.sdk.types.v3.api.error.APIException;
import com.opentext.otag.service.context.components.AWComponentContext;
import com.opentext.otag.service.context.error.AWComponentNotFoundException;
import com.opentext.otsync.connector.OTSyncConnector;
import com.opentext.otsync.connector.OTSyncConnectorConstants;
import com.opentext.otsync.connector.auth.registration.AuthRegistrationHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class is responsible for registering the Trusted Provider key
 * generated by the Gateway for Content Server. It wraps a thread that
 * will attempt the registration, we might not be able to register right
 * away as we need CS auth to be setup to do the registration.
 * <p>
 * As it is an {@code AWServiceContextHandler} implementation it will
 * be informed when the service is started and stopped.
 *
 * @see com.opentext.otsync.connector.OTSyncConnector#registerTrustedProviderKey(String, String)
 */
public class TrustedServerKeyRegistrationHandler extends AbstractMultiSettingChangeHandler
        implements AWServiceContextHandler {

    private static final Log LOG = LogFactory.getLog(TrustedServerKeyRegistrationHandler.class);

    private RegisterKeyThread registerKeyThread;
    private TrustedProviderClient trustedProviderClient;

    /**
     * Fire up the key registration Thread onStart.
     *
     * @param appName name of this app/service
     */
    @Override
    public void onStart(String appName) {
        LOG.info("Starting Trusted Provider Key registration");
        trustedProviderClient = new TrustedProviderClient();
        registerKeyThread = new RegisterKeyThread(trustedProviderClient);
        registerKeyThread.start();

        addHandler(OTSyncConnectorConstants.CS_ADMIN_USER, (s) -> {
            LOG.info("Restarting trusted server key thread as " + OTSyncConnectorConstants.CS_ADMIN_USER + " was changed to " + s.getNewValue());
            restartTrustedKeyThread();
        });
        addHandler(OTSyncConnectorConstants.CS_ADMIN_PWORD, (s) -> {
            LOG.info("Restarting trusted server key thread as " + OTSyncConnectorConstants.CS_ADMIN_PWORD + " was changed");
            restartTrustedKeyThread();
        });
    }

    public void updateProviderKey(String updatedKey) {
        OTSyncConnector connector;
        try {
            connector = AWComponentContext.getComponent(OTSyncConnector.class);
        } catch (AWComponentNotFoundException e) {
            LOG.warn("Failed to force provider key update as we could not resolve " +
                    "the OTSyncConnector in the AW Component Context");
            return;
        }

        connector.registerTrustedProviderKey(connector.getTrustedProviderName(), updatedKey);
    }

    private void restartTrustedKeyThread() {
        if (registerKeyThread != null && registerKeyThread.isAlive()) {
            LOG.info("Shutting down trusted key thread as we have been asked to restart");
            registerKeyThread.shutdown();
        }

        registerKeyThread = new RegisterKeyThread(trustedProviderClient);
        registerKeyThread.start();
    }

    @Override
    public void onStop(String appName) {
        if (registerKeyThread != null && registerKeyThread.isAlive())
            registerKeyThread.shutdown();
    }

    @Override
    public Set<String> getSettingKeys() {
        return new HashSet<>(Arrays.asList(OTSyncConnectorConstants.CS_ADMIN_USER, OTSyncConnectorConstants.CS_ADMIN_PWORD));
    }

    /**
     * Thread class that retrieves/creates the TrustedProvider key and
     * attempts the registration.
     */
    private static class RegisterKeyThread extends Thread {

        /**
         * The connector know how to perform the registration.
         */
        private OTSyncConnector connector;

        /**
         * The reg handler knows when we can use CS auth.
         */
        private AuthRegistrationHandler authRegistrationHandler;

        private String trustedServerKey;
        private String trustedServerName;

        private boolean keepRunning = true;

        public RegisterKeyThread(TrustedProviderClient providerClient) {
            super("Register Trusted Provider Key Thread");
            // we expect these components to be pre-seeded fail-fast if not
            try {
                connector = AWComponentContext.getComponent(OTSyncConnector.class);
                authRegistrationHandler = AWComponentContext.getComponent(AuthRegistrationHandler.class);
            } catch (AWComponentNotFoundException e) {
                throw new RuntimeException("We failed to locate te OTSyncConnector " +
                        "and/or AuthRegistrationHandler in the AW component context, the " +
                        "service has not initialised correctly");
            }

            if (connector == null)
                throw new IllegalStateException("Unable to resolve connector via the AWComponentContext");

            String errMessage = "Failed to retrieve/create Trusted Provider Key";
            TrustedProvider provider;
            try {
                provider = providerClient.getOrCreate(connector.getTrustedProviderName());
            } catch (APIException e) {
                LOG.error(errMessage + " - " + e.getCallInfo(), e);
                throw new RuntimeException(errMessage);
            }

            if (provider == null) {
                throw new RuntimeException(errMessage);
            }

            trustedServerKey = provider.getKey();
            trustedServerName = connector.getTrustedProviderName();
        }

        @Override
        public void run() {
            LOG.info("Started Trusted Server Key registration Thread");

            try {
                while (keepRunning) {
                    if (authRegistered()) {
                        LOG.info("Detected CS Auth Handler has been registered attempted to contact " +
                                "Content Server with Trusted provider key");
                        if (connector.registerTrustedProviderKey(trustedServerName, trustedServerKey)) {
                            keepRunning = false;
                            LOG.info("Registered Trusted Provider key with Content Server");
                        } else {
                            LOG.info("Attempted registration of Trusted Provider key failed, sleeping ...");
                            sleep();
                        }
                    } else {
                        LOG.info("OTSyncAuthHandler is yet to be registered so we cannot " +
                                "get an LLCookie to register our Trusted Provider key, sleeping ... ");
                        sleep();
                    }
                }
            } catch (Exception e) {
                LOG.error("Exception encountered in RegisterKeyThread, exiting", e);
            }
        }

        private boolean authRegistered() {
            if (authRegistrationHandler != null)
                return authRegistrationHandler.isAuthRegistered();

            authRegistrationHandler = AWComponentContext.getComponent(AuthRegistrationHandler.class);
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
