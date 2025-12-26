package com.dlassettrack.notification.repository;

import com.dlassettrack.notification.entity.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationLogRepository extends JpaRepository<NotificationLog,Long> {
}
