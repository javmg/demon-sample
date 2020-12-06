package com.sample.demon.notification.generator;

import com.sample.demon.mail.generator.EmailGenerator;
import com.sample.demon.mail.view.Email;
import com.sample.demon.notification.view.Notification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Locale;

@Component
public class NotificationGenerator implements EmailGenerator<Notification> {

    private final TemplateEngine templateEngine;
    private final String from;

    public NotificationGenerator(TemplateEngine templateEngine,
                                 @Value("${application.notification.from}") String from) {

        this.templateEngine = templateEngine;
        this.from = from;
    }

    @Override
    public Email generate(Notification criteria) {

        Context ctx = new Context(new Locale(criteria.getUserLocale()));
        ctx.setVariable("notification", criteria);

        String subject = templateEngine.process("/template/notification/notification_subject.html", ctx).trim();
        String body = templateEngine.process("/template/notification/notification_body.html", ctx);

        Email email = new Email();

        email.setFrom(from);
        email.setTo(criteria.getUserEmail());
        email.setSubject(subject);
        email.setBody(body);

        return email;
    }
}
