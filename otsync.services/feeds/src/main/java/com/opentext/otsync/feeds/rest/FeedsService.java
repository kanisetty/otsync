package com.opentext.otsync.feeds.rest;

import com.opentext.otag.sdk.client.ServiceClient;
import com.opentext.otag.sdk.connector.EIMConnectorClient;
import com.opentext.otag.sdk.connector.EIMConnectorClientImpl;
import com.opentext.otag.sdk.handlers.AppworksServiceContextHandler;
import com.opentext.otag.sdk.handlers.AppworksServiceStartupComplete;
import com.opentext.otag.api.shared.types.management.DeploymentResult;
import com.opentext.otag.api.shared.types.sdk.AppworksComponentContext;
import com.opentext.otag.api.shared.types.sdk.EIMConnector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class FeedsService implements AppworksServiceContextHandler {

    private static final Log LOG = LogFactory.getLog(FeedsService.class);

    private EIMConnector csConnection;
    private ServiceClient serviceClient;

    @AppworksServiceStartupComplete
    @Override
    public void onStart(String appName) {
        LOG.info("Started feeds service");
        serviceClient = new ServiceClient();

        try {
            EIMConnectorClient csConnector = new EIMConnectorClientImpl("OTSync", "16.0.0");
            EIMConnectorClient.ConnectionResult connectionResult = csConnector.connect();
            if (connectionResult.isSuccess()) {
                csConnection = connectionResult.getConnector();
            } else {
                failBuild("Failed to resolve the OTSync EIM " +
                        "connector, message=" + connectionResult.getMessage());
            }

            serviceClient.completeDeployment(new DeploymentResult(true));
        } catch (Exception e) {
            failBuild("Failed to start Feeds Service, " + e.getMessage());
        }
    }

    @Override
    public void onStop(String appName) {
        LOG.info("Feeds Service has stopped");
    }

    public String getCsConnection() {
        return (csConnection != null) ? csConnection.getConnectionUrl() : null;
    }

    public static FeedsService getService() {
        FeedsService feedsService = AppworksComponentContext.getComponent(FeedsService.class);
        if (feedsService == null)
            throw new RuntimeException("Unable to resolve FeedsService");

        return feedsService;
    }

    /**
     * Provide centralised public access to the connection URL we obtain from the
     * Content Server 10.5 connector.
     *
     * @return content server URL
     * @throws WebApplicationException 403, if we haven't managed to get a connection URL
     */
    public static String getCsUrl() {
        FeedsService feedsService = AppworksComponentContext.getComponent(FeedsService.class);
        if (feedsService == null) {
            LOG.error("Unable to resolve FeedsService, unable to get Content Server connection");
            throw new WebApplicationException(Response.Status.FORBIDDEN);
        }
        String csUrl = feedsService.getCsConnection();

        if (csUrl == null || csUrl.isEmpty()) {
            LOG.error("Unable to resolve Content Server connection, all requests will be rejected");
            throw new WebApplicationException(Response.Status.FORBIDDEN);
        }

        return csUrl;
    }

    private void failBuild(String errMsg) {
        LOG.error(errMsg);
        if (!serviceClient.completeDeployment(new DeploymentResult(errMsg))) {
            LOG.error("Failed to report deployment outcome to the Gateway");
        }
    }

}