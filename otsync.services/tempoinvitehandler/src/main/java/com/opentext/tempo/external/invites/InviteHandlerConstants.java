package com.opentext.tempo.external.invites;

public class InviteHandlerConstants {

    public static final String INVITE_HANDLER_APP_NAME = "tempoInviteHandler";

    // database config settings
    public static final String JDBC_URL = INVITE_HANDLER_APP_NAME + ".db.jdbcUrl";
    public static final String PASSWORD = INVITE_HANDLER_APP_NAME + ".db.password";
    public static final String USER_NAME = INVITE_HANDLER_APP_NAME + ".db.username";

    // OTDS config
    public static final String OTDS_PARTITION = INVITE_HANDLER_APP_NAME + ".otds.partition";
    public static final String OTDS_PARTITION_ADMIN_USER = INVITE_HANDLER_APP_NAME + ".otds.partition.admin";
    public static final String OTDS_PARTITION_ADMIN_PASSWORD = INVITE_HANDLER_APP_NAME + ".otds.partition.password";

    // email from setting
    public static final String EMAIL_FROM = INVITE_HANDLER_APP_NAME + ".email.from";
}
