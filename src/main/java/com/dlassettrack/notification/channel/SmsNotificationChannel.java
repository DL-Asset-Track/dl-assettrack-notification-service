package com.dlassettrack.notification.channel;

import com.dlassettrack.notification.entity.NotificationLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SmsNotificationChannel implements NotificationChannel {

    @Override
    public String getChannelType() {
        return "SMS";
    }

    @Override
    public void send(NotificationLog notification) {
        log.info("📱 Sending SMS to {} : {}",
                notification.getRecipient(),
                notification.getMessage());
    }
}
