package com.sample.demon.notification.sender;

import com.sample.demon.mail.sender.MailSenderClient;
import com.sample.demon.mail.view.Email;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Testing for {@link NotificationSender}
 */
@RunWith(SpringRunner.class)
@ActiveProfiles({"test"})
@SpringBootTest
public class NotificationSenderTest {

    @Autowired
    private NotificationSender notificationSender;

    @Autowired
    private MailSenderClient mockMailSenderClient;

    @Test
    public void testSendOk() {

        //
        // business

        notificationSender.send(2);

        //
        // verify emails were sent

        @SuppressWarnings("unchecked")
        ArgumentCaptor<List<Email>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        verify(mockMailSenderClient, times(1)).sendManyAsync(argumentCaptor.capture());

        List<Email> emails = argumentCaptor.getValue();

        assertThat(emails, containsInAnyOrder(
                allOf(
                        hasProperty("from", is("test@test.com")),
                        hasProperty("to", is("username_1@test.com")),
                        hasProperty("subject", containsString("1 pending")),
                        hasProperty("body", containsString("1 pending"))
                ),
                allOf(
                        hasProperty("from", is("test@test.com")),
                        hasProperty("to", is("username_2@test.com")),
                        hasProperty("subject", containsString("2 pending")),
                        hasProperty("body", containsString("2 pending"))
                )
        ));
    }
}
