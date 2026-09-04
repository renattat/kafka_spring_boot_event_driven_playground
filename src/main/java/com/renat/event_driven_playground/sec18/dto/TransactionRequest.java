package com.renat.event_driven_playground.sec18.dto;

public record TransactionRequest(
        String account,
        Integer amount,
        TransactionType type
) {
}
