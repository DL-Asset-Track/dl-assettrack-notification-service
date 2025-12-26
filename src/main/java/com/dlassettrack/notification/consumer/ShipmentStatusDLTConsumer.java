package com.dlassettrack.notification.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ShipmentStatusDLTConsumer {

    @KafkaListener(
            topics = "shipment.status.changed.DLT",
            groupId = "notification-dlt-group"
    )
    public void consumeDLT(String message) {
        log.error("🚨 Message moved to DLT: {}", message);
        // later: store in DB / alert ops team
    }
}
