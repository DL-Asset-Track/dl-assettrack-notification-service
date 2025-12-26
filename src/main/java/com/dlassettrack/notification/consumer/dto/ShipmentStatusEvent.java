package com.dlassettrack.notification.consumer.dto;

import lombok.Data;

@Data
public class ShipmentStatusEvent {

    private String eventType;
    private String shipmentId;
    private String status;
    private Long userId;
}
