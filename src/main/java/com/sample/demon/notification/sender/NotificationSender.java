package com.sample.demon.notification.sender;

import com.sample.demon.mail.generator.EmailGenerator;
import com.sample.demon.mail.sender.MailSenderClient;
import com.sample.demon.notification.service.NotificationService;
import com.sample.demon.notification.view.Notification;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationSender {

    public static final int MAX_NOTIFICATIONS = 100;

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final NotificationService notificationService;

    private final EmailGenerator<Notification> notificationEmailGenerator;

    private final MailSenderClient mailSenderClient;

    public void send() {
        send(MAX_NOTIFICATIONS);
    }

    public void send(int limit) {

        var pendingNotifications = notificationService.getPending(limit);

        log.debug("Retrieved {} pending notifications (limit was {}).", pendingNotifications.size(), limit);

        var emails = notificationEmailGenerator.generateMany(pendingNotifications);

        log.info("Sending {} emails...", emails.size());

        mailSenderClient.sendManyAsync(emails);
    }
}
