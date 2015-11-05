package com.opentext.otsync.content.ws.server.rest.resources.users;

import com.opentext.otsync.content.engine.core.SuspendedAction;
import com.opentext.otsync.content.http.HTTPRequestManager;
import com.opentext.otsync.content.message.Message;
import com.opentext.otsync.content.otag.ContentServerService;
import com.opentext.otsync.content.ws.server.rest.ResourcePath;
import com.opentext.otsync.content.ws.server.rest.resources.node.RESTDownloadAction;
import com.opentext.otsync.content.ws.server.rest.resources.node.RESTUploadAction;
import com.opentext.otag.rest.util.CSForwardHeaders;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class UserPhoto extends ResourcePath {

    @Override
    protected String getPath() {
        return "photo";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp,
                         String[] pathParams, int version) {
        String user = UserID.getUserID(pathParams);

        downloadUserPhoto(req, user, resp);
    }

    private void downloadUserPhoto(HttpServletRequest req, String user, HttpServletResponse resp) {
        String otcsticket = getOTCSTicket(req);

        if (otcsticket != null) {
            String url = new StringBuilder()
                    .append(ContentServerService.getCsUrl())
                    .append("?func=otsync.GetUserPhoto&userID=")
                    .append(user)
                    .toString();

            AsyncContext asyncRequest = req.startAsync();
            asyncRequest.setTimeout(getSettingsService().getServlet3RequestTimeout());

            HTTPRequestManager serverConnection = getServerConnection();

            SuspendedAction action = new RESTDownloadAction(serverConnection, asyncRequest, new CSForwardHeaders(req), url);

            getContentChannel().sendDownload(action, false);
        } else {
            rejectRequest(resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp,
                          String[] pathParams, int version) {
        String user = UserID.getUserID(pathParams);

        uploadProfilePhoto(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp,
                            String[] pathParams, int version) {
        String user = UserID.getUserID(pathParams);

        resetUserPhoto(req);
    }

    private void resetUserPhoto(HttpServletRequest req) {
        HashMap<String, Object> payload = Message.makePayload(
                Message.NOTIFY_KEY_VALUE, Message.DELETE_PROFILE_PHOTO_VALUE, req);

        getFrontChannel().sendFrontChannelPayload(req, payload, false);
    }

    private void uploadProfilePhoto(HttpServletRequest req, HttpServletResponse resp) {
        HashMap<String, Object> payload = Message.makePayload(
                Message.CONTENT_TYPE_KEY_VALUE, Message.UPLOAD_PROFILE_PHOTO_KEY_VALUE, req);
        RESTUploadAction.uploadRequest(req, resp, payload, RESTUploadAction.PHOTO_UPLOAD_PART_NAME);
    }
}