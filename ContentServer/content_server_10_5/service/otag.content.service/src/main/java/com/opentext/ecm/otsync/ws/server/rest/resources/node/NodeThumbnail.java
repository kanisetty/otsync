package com.opentext.ecm.otsync.ws.server.rest.resources.node;

import com.opentext.ecm.otsync.ContentServerService;
import com.opentext.ecm.otsync.engine.core.SuspendedAction;
import com.opentext.ecm.otsync.http.HTTPRequestManager;
import com.opentext.ecm.otsync.http.RequestHeader;
import com.opentext.ecm.otsync.message.Message;
import com.opentext.ecm.otsync.ws.server.rest.AdminAPI;
import com.opentext.ecm.otsync.ws.server.rest.ResourcePath;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class NodeThumbnail extends ResourcePath {
    @Override
    protected String getPath() {
        return "thumbnail";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp,
                         String[] pathParams, int version) {
        String node = NodeID.getNodeID(pathParams);

        downloadThumbnail(req, node, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp,
                         String[] pathParams, int version) {
        String node = NodeID.getNodeID(pathParams);

        setThumbnail(node, req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp,
                            String[] pathParams, int version) {
        String node = NodeID.getNodeID(pathParams);

        deleteThumbnail(node, req, resp);
    }

    private void downloadThumbnail(HttpServletRequest req, String nodeID, HttpServletResponse resp) {
        String llcookie = getCSToken(req);
        String allowDefault = req.getParameter(Message.ALLOW_DEFAULT);
        String type = req.getParameter(Message.TYPE);

        if (llcookie != null) {
            String url = new StringBuilder()
                    .append(ContentServerService.getCsUrl())
                    .append("?func=otsync.GetNodeThumbnail&nodeID=")
                    .append(nodeID)
                    .append("&type=")
                    .append(type)
                    .append("&allowDefault=")
                    .append(allowDefault)
                    .toString();

            AsyncContext asyncRequest = req.startAsync();
            asyncRequest.setTimeout(getSettingsService().getServlet3RequestTimeout());

            RequestHeader headers = new RequestHeader(req, llcookie);

            HTTPRequestManager serverConnection = getServerConnection();

            SuspendedAction action = new RESTDownloadAction(serverConnection, asyncRequest, headers, url, llcookie);

            getContentChannel().sendDownload(action, false);
        } else {
            rejectRequest(resp);
        }

    }

    private void setThumbnail(String node, HttpServletRequest req, HttpServletResponse resp) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("nodeID", node);

        RESTUploadAction.uploadAdminAPIRequest(Message.SET_THUMBNAIL_FUNC, params, "thumbnail", req, resp);
    }

    private void deleteThumbnail(String node, HttpServletRequest req,
                                 HttpServletResponse resp) {
        new AdminAPI(Message.DELETE_THUMBNAIL_FUNC, req, resp)
                .param("nodeID", node)
                .executeWithResponse();
    }

}
