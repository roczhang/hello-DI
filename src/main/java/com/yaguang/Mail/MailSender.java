package com.yaguang.Mail;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

/**
 * Created by I076057 on 2016/8/9.
 */
public interface  MailSender {


    void send(String to, String subject, String body) throws MessagingException;

    public String getName();



}
