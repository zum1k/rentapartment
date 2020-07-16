package com.training.rentapartment.controller.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class MailSender {
    private final String mailTo;
    private final String mailSubject;
    private final String mailText;
    private final String propertiesPath = "/res/mail.properties";
    private final int PORT = 465;
    private final String HOST = "smtp.gmail.com";
    private final String PROTOCOL = "smtps";
    private static final Logger logger = LogManager.getLogger(MailSender.class);

    public MailSender(String mailSubject, String mailText, String mailTo) {
        this.mailSubject = mailSubject;
        this.mailText = mailText;
        this.mailTo = mailTo;
    }

    public void send() {
        Transport transport = null;
        Session session = null;
        try {
            session = createSession(propertiesPath);
            transport = session.getTransport(PROTOCOL);
            transport.connect(HOST, PORT, session.getProperty("mail.user.name"), session.getProperty("mail.user.password"));
            MimeMessage message = initMessage(session);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            logger.error(e.getMessage(), e);
        }
    }

    private MimeMessage initMessage(Session session) throws MessagingException {
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setSubject(mailSubject);
        mimeMessage.setContent(mailText, "text/html");
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
        return mimeMessage;
    }

    private Session createSession(String propertiesPath) {
        Properties properties = new Properties();
        Session session = null;
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesPath));
            String userName = properties.getProperty("mail.user.name");
            String userPassword = properties.getProperty("mail.user.password");
            session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, userPassword);
                }
            });

        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return session;
    }
}
