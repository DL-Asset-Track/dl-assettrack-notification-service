package com.dlassettrack.notification.consumer;

import com.dlassettrack.notification.entity.NotificationLog;
import com.dlassettrack.notification.repository.NotificationLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class ShipmentStatusConsumer {

    private final NotificationLogRepository repository;
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "shipment.status.changed",
            groupId = "notification-service-group"
    )
    public void consume(String message) {
        try {
            log.info("📩 Received event: {}", message);
            var event = objectMapper.readTree(message);

            if ("FAILED".equals(event.get("status").asText())) {
                throw new RuntimeException("Simulated processing failure");
            }


            NotificationLog logEntity = NotificationLog.builder()
                    .eventType(event.get("eventType").asText())
                    .recipient("USER_" + event.get("userId").asLong())
                    .channel("EMAIL")
                    .message("Shipment " + event.get("shipmentId").asText()
                            + " status changed to " + event.get("status").asText())
                    .status("SENT")
                    .retryCount(0)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            repository.save(logEntity);

            log.info("✅ Notification saved successfully");
        }catch (Exception e){
            log.error("❌ Failed to process message", e);
            throw e;
        }
    }
}
