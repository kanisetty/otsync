package com.opentext.otsync.content.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opentext.otag.rest.util.CSForwardHeaders;
import com.opentext.otsync.content.ContentServiceConstants;
import com.opentext.otsync.content.http.HTTPRequestManager;
import com.opentext.otsync.content.message.Message;
import com.opentext.otsync.content.message.SynchronousMessageListener;
import com.opentext.otsync.content.ws.ServletConfig;
import com.opentext.otsync.content.ws.message.MessageConverter;
import com.opentext.otsync.content.ws.server.ClientTypeSet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// TODO FIXME this legacy endpoint should be deprecated once AppWorks implements all required features
// and clients can be updated
public class AuthMessageListener implements SynchronousMessageListener {

    private MessageConverter _messageConverter;
    private static Log log = LogFactory.getLog(AuthMessageListener.class);
    private ClientTypeSet _clientSet;

    public AuthMessageListener(MessageConverter messageConverter, HTTPRequestManager serverConnection) {
        _messageConverter = messageConverter;

        _clientSet = new ClientTypeSet();
    }

    /**
     * Authenticate the user based on the incoming auth parameters
     * if an IOException is thrown, the message service will catch it
     * and return an HTTP error to the client indicating that the message could not be forwarded
     *
     * @param message - incoming request map with legacy FrontChannel format
     * @return - Map containing all fields to be returned to the requesting client
     * @throws IOException
     */
    public Map<String, Object> onMessage(Map<String, Object> message) throws IOException {
        Map<String, Object> combinedResult = generateDefaultResponse();

        Map<String, Object> awAuthResult = doAppWorksAuth(message);
        combinedResult.putAll(awAuthResult);

        Map<String, Object> csAuthResult = doContentServerAuth(message);
        combinedResult.putAll(csAuthResult);

        Map<String, Object> versionData = _clientSet.doClientVersionCheck(message);
        combinedResult.putAll(versionData);

        return combinedResult;
    }

    /**
     * Take the incoming request map and pull out the values required for AppWorks Auth
     *
     * @param message - Incoming request map
     * @return - JSON string containing the expected AppWorks Auth string
     */
    private String buildAWAuthRequestString(Map<String, Object> message) {
        Map<String, Object> params = new HashMap<>();
        params.put("userName", message.getOrDefault(Message.USERNAME_KEY_NAME, ""));
        params.put("password", message.getOrDefault(Message.PASSWORD_KEY_NAME, ""));

        //If the client has passed in its ID, include it
        if (message.containsKey(Message.CLIENT_ID_KEY_NAME)) {
            params.put("clientId", message.getOrDefault(Message.CLIENT_ID_KEY_NAME, ""));
        }

        Map<String, Object> clientData = new HashMap<>();
        params.put("clientData", clientData);
        Map<String, Object> clientInfo = new HashMap<>();
        clientData.put("clientInfo", clientInfo);

        clientInfo.put("type", message.getOrDefault(Message.CLIENT_TYPE_KEY_NAME, ""));
        clientInfo.put("version", message.getOrDefault(Message.CLIENT_CURRENTVERSION_KEY_VALUE, ""));
        clientInfo.put("os", message.getOrDefault(Message.CLIENT_OS_KEY_NAME, ""));
        clientInfo.put("osVersion", message.getOrDefault(Message.CLIENT_OSVERSION_KEY_NAME, ""));
        clientInfo.put("bitness", message.getOrDefault(Message.CLIENT_BITNESS_KEY_NAME, ""));

        ObjectMapper mapper = new ObjectMapper();
        String requestJSON = null;

        try {
            requestJSON = mapper.writeValueAsString(params);
        } catch (JsonProcessingException e) {
            log.error(e);
        }

        return requestJSON;
    }

    /**
     * Authenticate with AppWorks to get authentication tokens required for AppWorks services
     *
     * @param message - Map containing the incoming request body
     * @return - Map containing required tokens and info mapped to the legacy API response format
     * @throws IOException
     */
    private Map<String, Object> doAppWorksAuth(Map<String, Object> message) throws IOException {
        Map<String, Object> result = new HashMap<>();
        String requestJSON = buildAWAuthRequestString(message);
        CSForwardHeaders headers = (CSForwardHeaders) message.get(CSForwardHeaders.REQUEST_HEADER_KEY);


        //Build up AppWorks Auth request using incoming request's URL
        String requestScheme = (String) message.getOrDefault("request_scheme", "http");
        Integer requestPort = (Integer) message.getOrDefault("request_port", 8080);
        String requestServer = (String) message.getOrDefault("request_server_name", "localhost");
        HttpResponse response;

        HttpClient httpClient = new DefaultHttpClient();
        try {
            URL requestURL = new URL(requestScheme, requestServer, requestPort, "/admin/auth");
            HttpPost request = new HttpPost(requestURL.toString());

            //Add in headers from the incoming request e.g. X-Forwarded-For
            if (headers != null) {
                headers.addTo(request);
            }
            request.addHeader("content-type", "application/json");
            request.setEntity(new StringEntity(requestJSON));
            response = httpClient.execute(request);
        } catch (Exception e) {
            log.error(e);
            throw e;
        }

        if (response.getStatusLine().getStatusCode() == 200) {
            result.put("auth", Boolean.TRUE);
        } else {
            // If auth was unsuccessful, return the expected legacy error data structure
            result.put("info", generateErrorInfo(
                    response.getStatusLine().getReasonPhrase(),
                    response.getStatusLine().getStatusCode()));
            return result;
        }

        String responseString;
        Map<String, Object> workingMap;
        try {
            responseString = EntityUtils.toString(response.getEntity());
            workingMap = _messageConverter.getDeserializer().deserialize(responseString);
        } catch (IOException e) {
            log.error(e);
            throw e;
        }

        //Map AW response fields to expected API response
        result.put("token", workingMap.getOrDefault("otagtoken", ""));
        result.put("isOTAG", workingMap.getOrDefault("isOTAG", false));
        result.put("clientID", workingMap.getOrDefault("id", ""));

        if (workingMap.get("wipe") != null) {
            result.put("wipe", workingMap.get("wipe"));
        }

        return result;
    }

    /**
     * Authenticate with Content Service module to get authentication token required for Content Server calls
     * Also returns system preferences and user info required by the legacy desktop and web clients
     *
     * @param message - Map containing the incoming request body
     * @return - Map containing required tokens and info mapped to the legacy API response format
     * @throws IOException
     */
    private Map<String, Object> doContentServerAuth(Map<String, Object> message) throws IOException {
        Map<String, Object> result = new HashMap<>();
        CSForwardHeaders headers = (CSForwardHeaders) message.get(CSForwardHeaders.REQUEST_HEADER_KEY);
        ArrayList<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("func", "otsync.otsyncrequest"));

        try {
            params.add(new BasicNameValuePair("payload", _messageConverter.getSerializer().serialize(message)));
        } catch (IOException e) {
            log.error(e);
            return new HashMap<>();
        }

        HttpResponse response;
        HttpClient httpClient = new DefaultHttpClient();

        try {
            HttpPost request = new HttpPost(ServletConfig.getContentServerUrl());
            //Add in headers from the incoming request e.g. X-Forwarded-For
            if (headers != null) {
                headers.addTo(request);
            }

            request.setEntity(new UrlEncodedFormEntity(params));
            response = httpClient.execute(request);
        } catch (IOException e) {
            log.error(e);
            throw e;
        }

        String responseString;
        Map<String, Object> workingMap;

        try {
            responseString = EntityUtils.toString(response.getEntity());
            workingMap = _messageConverter.getDeserializer().deserialize(responseString);
        } catch (IOException e) {
            log.error(e);
            throw e;
        }

        //Insert extra required info data
        Map<String, Object> info = (Map<String, Object>) workingMap.get("info");
        if (info != null) {
            info.put(Message.SYNC_RECOMMENDED_KEY_NAME, false);
            if (Boolean.FALSE.equals(info.get("auth"))) {
                result.put("auth", Boolean.FALSE);
            }
        }

        //Map CS response fields to current expected API response
        result.put("APIVersion", workingMap.getOrDefault("APIVersion", 4));
        result.put("cstoken", workingMap.getOrDefault("otcsticket", ""));
        result.put("info", workingMap.get("info"));
        result.put("serverDate", workingMap.get("serverDate"));
        result.put("subtype", workingMap.getOrDefault("subtype", "auth"));
        result.put("type", workingMap.getOrDefault("type", "auth"));

        return result;
    }

    /**
     * Legacy clients expect the nested info structure from Content Server whether the auth/version check succeed or not
     * If authentication is blocked prior to hitting Content Server, fake this structure
     *
     * @param errMsg     - English description of the error for logging
     * @param statusCode - HTTP status code
     * @return - Info map with info on the error condition
     */
    private Map<String, Object> generateErrorInfo(String errMsg, int statusCode) {
        Map<String, Object> info = new HashMap<>();
        info.put("auth", Boolean.FALSE);
        info.put("errMsg", errMsg);
        info.put("statusCode", statusCode);
        info.put("exceptionCode", "badlogin");
        info.put("ok", Boolean.FALSE);

        return info;
    }

    /**
     * Legacy clients expect default fields to be present and can crash if missing
     * Add these fields with defaults to the response prior to any validation.
     *
     * @return - map containing default fields and values
     */
    private Map<String, Object> generateDefaultResponse() {
        Map<String, Object> result = new HashMap<>();

        result.put("APIVersion", 4);
        result.put("clientID", null);
        result.put("info", generateErrorInfo("Unknown request error", 400));
        result.put("serverDate", null);
        result.put("subtype", "auth");
        result.put("type", "auth");
        result.put("clientOS", null);
        result.put("clientCurVersion", null);
        result.put("clientMinVersion", null);
        result.put("clientLink", null);
        result.put("auth", false);
        result.put("clientNeedsUpgrade", false);
        result.put(Message.MAX_STORED_RESPONSES_KEY_NAME, ContentServiceConstants.DEFAULT_STORED_RESPONSES);
        result.put("isOTAG", false);

        return result;
    }
}