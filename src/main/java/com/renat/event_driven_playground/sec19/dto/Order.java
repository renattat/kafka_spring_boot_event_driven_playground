package com.renat.event_driven_playground.sec19.dto;

public record Order(int id,
                    int customerId,
                    int amount,
                    ProductType productType) {
}