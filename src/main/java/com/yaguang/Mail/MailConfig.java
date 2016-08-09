package com.yaguang.Mail;

/**
 * Created by I076057 on 8/9/2016.
 */

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

    @Bean
    @ConditionalOnProperty(name="spring.mail.host",
            havingValue="foo",
            matchIfMissing=true)
    public MailSender mockMailSender() {
        return new MockMailSender();
    }

    @Bean
    @ConditionalOnProperty(name="spring.mail.host")
    public MailSender smtpMailSender(JavaMailSender javaMailSender) {
        STMPMailSender mailSender = new STMPMailSender();
        mailSender.setJavaMailSender(javaMailSender);
        return mailSender;
    }
}
