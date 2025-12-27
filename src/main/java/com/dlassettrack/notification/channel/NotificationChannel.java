package com.dlassettrack.notification.channel;

import com.dlassettrack.notification.entity.NotificationLog;

public interface NotificationChannel {

    String getChannelType();   // EMAIL, SMS, PUSH

    void send(NotificationLog notification);
}
