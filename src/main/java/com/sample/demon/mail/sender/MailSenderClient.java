package com.sample.demon.mail.sender;

import com.sample.demon.mail.view.Email;

import java.util.Collection;

public interface MailSenderClient {

    void send(Email email);

    default void sendMany(Collection<Email> collection){
        collection.forEach(this::send);
    }

    default void sendAsync(Email email){
            new Thread(() -> send(email)).start();
    }

    default void sendManyAsync(Collection<Email> collection){
        collection.forEach(this::sendAsync);
    }
}
