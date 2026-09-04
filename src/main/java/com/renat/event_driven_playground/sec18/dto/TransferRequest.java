package com.renat.event_driven_playground.sec18.dto;

public record TransferRequest(
        String formAmount,
        String toAccount,
        Integer amount
) {
}
