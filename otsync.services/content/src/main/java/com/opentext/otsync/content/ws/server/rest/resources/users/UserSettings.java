package com.opentext.otsync.content.ws.server.rest.resources.users;

import com.opentext.otsync.content.ws.server.rest.ResourcePath;
import com.opentext.otsync.content.message.Message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;

public class UserSettings extends ResourcePath {

    @Override
    protected String getPath() {
        return "settings";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp,
                         String[] pathParams, int version) {
        getSettings(req);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp,
                         String[] pathParams, int version) {
        setSettings(req);
    }

    private void getSettings(HttpServletRequest req) {
        HashMap<String, Object> payload = Message.makePayload(Message.NOTIFY_KEY_VALUE, Message.GET_SETINGS_VALUE, req);

        getFrontChannel().sendFrontChannelPayload(req, payload, false);
    }

    private void setSettings(HttpServletRequest req) {
        HashMap<String, Object> payload = Message.makePayload(Message.NOTIFY_KEY_VALUE, Message.SET_SETINGS_VALUE, req);

        Enumeration<String> reqParams = req.getParameterNames();
        while (reqParams.hasMoreElements()) {
            String param = reqParams.nextElement();
            Message.infoPut(payload, param, Boolean.parseBoolean(req.getParameter(param)));
        }
        getFrontChannel().sendFrontChannelPayload(req, payload, false);
    }

}
