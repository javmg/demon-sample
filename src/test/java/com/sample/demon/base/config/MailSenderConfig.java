package com.sample.demon.base.config;

import com.sample.demon.mail.sender.MailSenderClient;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailSenderConfig {

    @Bean
    public MailSenderClient mailSenderClient() {
        return Mockito.mock(MailSenderClient.class);
    }
}
