package com.sample.demon.notification.service;

import com.sample.demon.notification.view.Notification;

import java.util.List;

public interface NotificationService {

    List<Notification> getPending(int limit);
}
