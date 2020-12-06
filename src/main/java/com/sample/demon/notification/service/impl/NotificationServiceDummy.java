package com.sample.demon.notification.service.impl;

import com.sample.demon.notification.service.NotificationService;
import com.sample.demon.notification.view.Notification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class NotificationServiceDummy implements NotificationService {

    @Override
    public List<Notification> getPending(int limit) {

        return IntStream.range(0, limit)

                .mapToObj((index) -> {

                    var notification = new Notification();

                    int id = index + 1;

                    notification.setUserLocale("en");
                    notification.setUserEmail(String.format("username_%s@test.com", id));
                    notification.setUserFirstName(String.format("firstName_%s", id));
                    notification.setNumPending(id);

                    return notification;

                })

                .collect(Collectors.toList());
    }
}
