package com.yaguang.Mail;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by I076057 on 2016/8/9.
 */



public class MockMailSender implements MailSender {


    @Override
   public void send(String to, String subject, String body) throws MessagingException
    {
        System.out.println( "Send mailer by MockMailSender");
    }

    public String getName()
    {
        return "MockMailSender";
    }
}
