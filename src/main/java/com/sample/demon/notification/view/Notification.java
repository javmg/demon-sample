package com.sample.demon.notification.view;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notification {

    private String userLocale;

    private String userFirstName;

    private String userEmail;

    private Integer numPending;
}
