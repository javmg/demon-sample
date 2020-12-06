package com.sample.demon.mail.sender.impl;

import com.sample.demon.base.exception.GeneralException;
import com.sample.demon.mail.sender.MailSenderClient;
import com.sample.demon.mail.view.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RequiredArgsConstructor
public class MailSenderClientSmtp implements MailSenderClient {

    private final JavaMailSender javaMailSender;

    @Override
    public void send(Email email) {

        try {

            MimeMessage message = javaMailSender.createMimeMessage();

            message.setFrom(email.getFrom());
            message.setText(email.getBody(), "UTF-8", "html");
            message.setSubject(email.getSubject(), "UTF-8");

            message.setRecipients(RecipientType.TO, email.getTo());

            javaMailSender.send(message);
        } catch (MessagingException exception) {
            throw new GeneralException(exception);
        }
    }
}
