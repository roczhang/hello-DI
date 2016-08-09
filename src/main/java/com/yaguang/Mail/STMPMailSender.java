package com.yaguang.Mail;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

/**
 * Created by I076057 on 2016/8/9.
 */


public class STMPMailSender implements  MailSender {


    private static final Log log = LogFactory.getLog(STMPMailSender.class);

    private JavaMailSender javaMailSender;

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    @Override
    public void send(String to, String subject, String body) throws MessagingException
    {
        System.out.println( "Send mailer by STMPMailSender");

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;

        try {
            helper = new MimeMessageHelper(message, true); // true indicates
            // multipart message
            helper.setSubject(subject);
            helper.setTo(to);
            helper.setText(body, true); // true indicates html

            // continue using helper for more functionalities
            // like adding attachments, etc.

            javaMailSender.send(message);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }

    }


    public String getName()
    {
        return "STMPMailSender";
    }
}
