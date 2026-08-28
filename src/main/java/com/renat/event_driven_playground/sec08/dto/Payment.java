package com.renat.event_driven_playground.sec08.dto;

import java.util.UUID;

public record Payment(
        int orderId,
        int amount,
        UUID paymentId
) {
}
