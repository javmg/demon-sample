package com.sample.demon.notification.poller;

import com.sample.demon.notification.sender.NotificationSender;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationPoller {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final NotificationSender notificationSender;

    @Scheduled(cron = "${application.notification.cron}")
    public void poll() {

        log.debug("Notification poller executing...");

        notificationSender.send();

        log.info("Notification poller executed.");
    }
}
