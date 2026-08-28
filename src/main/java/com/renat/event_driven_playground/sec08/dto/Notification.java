package com.renat.event_driven_playground.sec08.dto;

public record Notification(int orderId,
                           NotificationChannel channel,
                           String recipient) {
}
