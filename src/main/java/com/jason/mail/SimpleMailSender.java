package com.jason.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SimpleMailSender {
    private final Properties pros = new Properties();
    private MailAuthenticator mailAuthenticator;
    private Session session;

    public SimpleMailSender(String smtpHostName, String username, String password) {
        init(smtpHostName, username, password);
    }

    private void init(String smtpHostName, String username, String password) {
        pros.put("mail.smtp.auth", "true");
        pros.put("mail.smtp.host", smtpHostName);
        mailAuthenticator = new MailAuthenticator(username, password);
        session = Session.getDefaultInstance(pros, mailAuthenticator);
    }

    public SimpleMailSender(String username, String password) {
        String smtpHostName = "smtp." + username.split("@")[1];
        init(smtpHostName, username, password);
    }

    public void send(String recipient, String subject, Object content) throws MessagingException {
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress(mailAuthenticator.getUsername()));
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        mimeMessage.setSubject(subject);
        mimeMessage.setContent(content.toString(), "text/html;charset=utf-8");
        Transport.send(mimeMessage);
    }
}
