package com.yaguang.controls;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.yaguang.Mail.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class HelloController{

    private  MailSender mailSender;

    @Value("${appname}")
    private  String appName;



    @Autowired
    void HelloController( MailSender mailSender)
    {
        this.mailSender = mailSender;
    }


    @RequestMapping("/hello")
    public String hello()
    {
        try {
            mailSender.send("1836029598@qq.com","test","hello,world");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return mailSender.getName() + appName;
    }
}