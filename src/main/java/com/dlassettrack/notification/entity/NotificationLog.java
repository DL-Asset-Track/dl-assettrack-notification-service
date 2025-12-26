package com.dlassettrack.notification.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification_log")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventType;
    private String recipient;
    private String channel;

    @Column(columnDefinition = "TEXT")
    private String message;

    private String status;
    private Integer retryCount;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
