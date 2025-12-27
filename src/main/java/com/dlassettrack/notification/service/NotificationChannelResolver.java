package com.dlassettrack.notification.service;

import com.dlassettrack.notification.channel.NotificationChannel;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class NotificationChannelResolver {

    private final List<NotificationChannel> channels;
    private final Map<String, NotificationChannel> channelMap = new HashMap<>();

    @PostConstruct
    public void init() {
        for (NotificationChannel channel : channels) {
            channelMap.put(channel.getChannelType(), channel);
        }
    }

    public NotificationChannel resolve(String channelType) {
        return channelMap.get(channelType);
    }
}
