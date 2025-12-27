package com.dlassettrack.notification.channel;

import com.dlassettrack.notification.entity.NotificationLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailNotificationChannel implements NotificationChannel{

    @Override
    public String getChannelType() {
        return "EMAIL";
    }

    @Override
    public void send(NotificationLog notification) {
        // MOCK for now
        log.info("📧 Sending EMAIL to {} : {}",
                notification.getRecipient(),
                notification.getMessage());
    }
}
