package Intg.com.jason.controller;

import com.jason.mail.MailSenderFactory;
import com.jason.mail.SimpleMailSender;
import org.junit.Test;

public class MailSendTest {
    @Test
    public void test_simpleMailSender_can_send_mail_success() throws Exception {
        SimpleMailSender simpleMailSender = MailSenderFactory.getSimpleMailSender();
        simpleMailSender.send("519875872@qq.com", "修改密码", "重置密码的链接是:www.czmima.com/kljfsdg?userId=fjdsf");

    }
}
