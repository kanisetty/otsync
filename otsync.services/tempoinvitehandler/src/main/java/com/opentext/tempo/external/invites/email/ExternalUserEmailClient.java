package com.opentext.tempo.external.invites.email;

import com.opentext.otag.sdk.client.v3.MailClient;
import com.opentext.otag.sdk.types.v3.MailRequest;
import com.opentext.otag.sdk.types.v3.api.error.APIException;
import com.opentext.tempo.external.invites.handler.XmlPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Collections;

/**
 * This client is responsible for creating email from the templates provided within
 * this service, and sending them via the AppWorks Gateway SDK.
 */
public class ExternalUserEmailClient {

    private static final Logger LOG = LoggerFactory.getLogger(ExternalUserEmailClient.class);

    /**
     * AppWorks SDK mail client.
     */
    private MailClient mailClient;

    /**
     * Email from address settings handler
     */
    private EmailFromAddressHandler fromAddressHandler;

    public ExternalUserEmailClient(MailClient mailClient,
                                   EmailFromAddressHandler fromAddressHandler) {
        this.mailClient = mailClient;
        this.fromAddressHandler = fromAddressHandler;
    }

    public void sendSuccessEmail(ServletContext context, XmlPackage xml, String email, String langFolder)
            throws IOException, TransformerException, MessagingException {

        sendContextEmail(context, langFolder + "/successemail-subject.xsl",
                langFolder + "/successemail.xsl", xml, email);
    }

    public void sendInvitationEmail(ServletContext context, XmlPackage xml, String email, String langFolder)
            throws IOException, TransformerException, MessagingException {

        sendContextEmail(context, langFolder + "/invitationemail-subject.xsl",
                langFolder + "/invitationemail.xsl", xml, email);
    }

    public void sendPasswordResetEmail(ServletContext context, XmlPackage xml, String email, String langFolder)
            throws IOException, TransformerException, MessagingException {

        sendContextEmail(context, langFolder + "/passwordresetemail-subject.xsl",
                langFolder + "/passwordresetemail.xsl", xml, email);
    }

    private void sendContextEmail(ServletContext context, String subjectxsl, String bodyxsl,
                                  XmlPackage xml, String email)
            throws IOException, TransformerException, MessagingException {

        InputStream xslSubject = context.getResourceAsStream("/WEB-INF/xsl/" + subjectxsl);
        String xslSubjectPath = context.getRealPath("/WEB-INF/xsl/" + subjectxsl);

        InputStream xslBody = context.getResourceAsStream("/WEB-INF/xsl/" + bodyxsl);
        String xslBodyPath = context.getRealPath("/WEB-INF/xsl/" + bodyxsl);

        StringWriter subjectStringWriter = new StringWriter();
        StringWriter bodyStringWriter = new StringWriter();

        xml.write(subjectStringWriter, xslSubjectPath, xslSubject);
        xml.write(bodyStringWriter, xslBodyPath, xslBody);

        try {
            String mailFromSetting = fromAddressHandler.getFromAddress();
            if (mailFromSetting != null) {
                MailRequest mailRequest = new MailRequest(mailFromSetting, Collections.singletonList(email),
                        subjectStringWriter.toString(), bodyStringWriter.toString());
                mailClient.sendMail(mailRequest);
            } else {
                LOG.warn("Failed to get the Gateway's \"from\" email address setting");
            }
        } catch (APIException e) {
            LOG.error("Gateway API call failed, could not send email - " + e.getCallInfo());
        }
    }

}