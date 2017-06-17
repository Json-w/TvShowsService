package com.jason.mail;

public class MailSenderFactory {
    private static SimpleMailSender simpleMailSender = null;

    public static SimpleMailSender getSimpleMailSender() {
        if (simpleMailSender == null) {

            simpleMailSender = new SimpleMailSender("wangpei9679@163.com", "xxxx");
        }
        return simpleMailSender;
    }
}
