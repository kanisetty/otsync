package com.opentext.ecm.otsync.ws.server.rest.resources.node;

import com.opentext.ecm.otsync.ContentServiceConstants;
import com.opentext.ecm.otsync.engine.core.SuspendedAction;
import com.opentext.ecm.otsync.http.HTTPRequestManager;
import com.opentext.ecm.otsync.http.RequestHeader;
import com.opentext.ecm.otsync.message.Message;
import com.opentext.ecm.otsync.ws.ServletUtil;
import com.opentext.ecm.otsync.ws.server.rest.ResourcePath;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class NodeContent extends ResourcePath {

    @Override
    protected String getPath() {
        return "content";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp,
                         String[] pathParams, int version) {
        String node = NodeID.getNodeID(pathParams);

        download(req, resp, node);
    }

    private void download(HttpServletRequest req, HttpServletResponse resp, String node) {
        String version = req.getParameter(Message.VERSION_KEY_REST_NAME);
        String llcookie = getCSToken(req);
        boolean auto = Boolean.parseBoolean(req.getParameter(Message.AUTO_MODE_KEY_NAME));

        if (llcookie != null) {
            String url = ServletUtil.getDownloadUrlForID(node, version);

            AsyncContext asyncRequest = req.startAsync();
            asyncRequest.setTimeout(getSettingsService().getServlet3ContentTimeout());

            RequestHeader headers = new RequestHeader(req);

            HTTPRequestManager serverConnection = getServerConnection();

            SuspendedAction action = new RESTDownloadAction(serverConnection, asyncRequest, headers, url, llcookie);

            // enqueue only downloads marked "auto", representing automatic file-sync;
            // others can run directly on this thread
            getContentChannel().sendDownload(action, auto);
        } else {
            rejectRequest(resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp,
                          String[] pathParams, int version) {
        if (req.getContentType().startsWith(ContentServiceConstants.FILE_UPLOAD_TYPE)) {
            String node = NodeID.getNodeID(pathParams);
            uploadVersion(req, resp, node);
        } else {
            publishVersionToFile(req, resp, pathParams);
        }
    }

    private void uploadVersion(HttpServletRequest req, HttpServletResponse resp, String nodeID) {
        HashMap<String, Object> payload = Message.makePayload(Message.CONTENT_TYPE_KEY_VALUE, Message.UPLOAD_VERSION_KEY_VALUE, req);
        Message.infoPut(payload, Message.NODE_ID_KEY_NAME, nodeID);

        RESTUploadAction.uploadRequest(req, resp, payload, RESTUploadAction.FILE_UPLOAD_PART_NAME);
    }

    private void publishVersionToFile(HttpServletRequest req,
                                      HttpServletResponse resp, String[] pathParams) {
        String node = NodeID.getNodeID(pathParams);
        boolean deleteOriginal = ContentServiceConstants.TRUE_STRING.equalsIgnoreCase(
                req.getParameter(Message.DELETE_ORIGINAL_KEY_NAME));
        String source = req.getParameter(Message.COPY_FROM_KEY_NAME);

        if (source == null) {
            rejectRequest(resp);
        } else if (deleteOriginal) {
            publishToFileMove(req, node, source);
        } else {
            publishToFileCopy(req, node, source);
        }
    }

    private void publishToFileMove(HttpServletRequest req, String node, String source) {
        String version = req.getParameter(Message.VERSION_KEY_NAME);
        HashMap<String, Object> payload = Message.makePayload(
                Message.NOTIFY_KEY_VALUE, Message.PUBLISH_TO_FILE_MOVE, req);
        Message.infoPut(payload, Message.NODE_ID_KEY_NAME, source);
        Message.infoPut(payload, Message.TARGET_KEY_NAME, node);
        Message.infoPut(payload, Message.VERSION_KEY_NAME, version);

        getFrontChannel().sendFrontChannelPayload(req, payload, false);
    }

    private void publishToFileCopy(HttpServletRequest req, String node, String source) {
        String version = req.getParameter(Message.VERSION_KEY_NAME);
        HashMap<String, Object> payload = Message.makePayload(
                Message.NOTIFY_KEY_VALUE, Message.PUBLISH_TO_FILE_COPY, req);
        Message.infoPut(payload, Message.NODE_ID_KEY_NAME, source);
        Message.infoPut(payload, Message.TARGET_KEY_NAME, node);
        Message.infoPut(payload, Message.VERSION_KEY_NAME, version);

        getFrontChannel().sendFrontChannelPayload(req, payload, false);
    }

}