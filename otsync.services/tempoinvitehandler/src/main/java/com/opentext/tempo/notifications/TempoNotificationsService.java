package com.opentext.tempo.notifications;

import com.opentext.otag.sdk.client.v3.AuthClient;
import com.opentext.otag.sdk.client.v3.ServiceClient;
import com.opentext.otag.sdk.client.v3.SettingsClient;
import com.opentext.otag.sdk.connector.EIMConnectorClient;
import com.opentext.otag.sdk.connector.EIMConnectorClientImpl;
import com.opentext.otag.sdk.handlers.AWServiceContextHandler;
import com.opentext.otag.sdk.handlers.AWServiceStartupComplete;
import com.opentext.otag.sdk.types.v3.api.SDKResponse;
import com.opentext.otag.sdk.types.v3.api.error.APIException;
import com.opentext.otag.sdk.types.v3.management.DeploymentResult;
import com.opentext.otag.sdk.types.v3.sdk.EIMConnector;
import com.opentext.otag.service.context.components.AWComponentContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class TempoNotificationsService implements AWServiceContextHandler {

    private static final Log LOG = LogFactory.getLog(TempoNotificationsService.class);

    private EIMConnector csConnection;
    private ServiceClient serviceClient;

    private AuthClient authClient;
    private SettingsClient settingsClient;

    @AWServiceStartupComplete
    @Override
    public void onStart(String appName) {
        LOG.info("Started Tempo Notifications service");
        serviceClient = new ServiceClient();
        settingsClient = new SettingsClient();
        authClient = new AuthClient();

        try {
            EIMConnectorClient csConnector = new EIMConnectorClientImpl("OTSync", "16.0.1");
            EIMConnectorClient.ConnectionResult connectionResult = csConnector.connect();
            if (connectionResult.isSuccess()) {
                csConnection = connectionResult.getConnector();
                String connectionUrl = csConnection.getConnectionUrl();
                if (connectionUrl != null && !connectionUrl.isEmpty()) {
                    serviceClient.completeDeployment(new DeploymentResult(true));
                } else {
                    failBuild("OTSync EIM Connector was resolved but connection URL was not valid");
                }
            } else {
                failBuild("Failed to resolve the OTSync EIM " +
                        "connector, message=" + connectionResult.getMessage());
            }

        } catch (Exception e) {
            failBuild("Failed to start Tempo Notifications Service, " + e.getMessage());
        }
    }

    @Override
    public void onStop(String appName) {
        LOG.info("Tempo Notifications Service has stopped");
    }

    public SettingsClient getSettingsClient() {
        return settingsClient;
    }

    public AuthClient getAuthClient() {
        return authClient;
    }

    public String getCsConnection() {
        return (csConnection != null) ? csConnection.getConnectionUrl() : null;
    }

    public static String getCsUrl() {
        TempoNotificationsService tempoNotificationsService = AWComponentContext.getComponent(TempoNotificationsService.class);

        if (tempoNotificationsService != null) {
            String csConnection = tempoNotificationsService.getCsConnection();
            if (csConnection != null)
                return csConnection;
        }

        LOG.error("Unable to service tempo notifications request, unable to get CS connection URL");
        throw new WebApplicationException(Response.Status.FORBIDDEN);
    }

    private void failBuild(String errMsg) {
        String reportFailureMsg = "Failed to report deployment outcome to the Gateway";
        try {
            LOG.error(errMsg);
            SDKResponse sdkResponse = serviceClient.completeDeployment(new DeploymentResult(errMsg));
            if (!sdkResponse.isSuccess()) {
                LOG.error(reportFailureMsg);
            }
        } catch (APIException e) {
            LOG.error(errMsg + " - " + e.getCallInfo());
        }
    }
}
