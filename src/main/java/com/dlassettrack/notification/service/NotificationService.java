package com.dlassettrack.notification.service;


import com.dlassettrack.notification.channel.NotificationChannel;
import com.dlassettrack.notification.entity.NotificationLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationChannelResolver resolver;

    public void send(NotificationLog notification){

        NotificationChannel channel = resolver.resolve(notification.getChannel());

        if (channel == null) {
            throw new IllegalArgumentException(
                    "Unsupported channel: " + notification.getChannel());
        }

        channel.send(notification);
    }
}
