package com.sample.demon.base.config;

import com.sample.demon.mail.sender.MailSenderClient;
import com.sample.demon.mail.sender.impl.MailSenderClientSmtp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailSenderConfig {

    @Bean
    public MailSenderClient mailSenderClient(JavaMailSender javaMailSender) {
        return new MailSenderClientSmtp(javaMailSender);
    }
}
