package com.renat.event_driven_playground.sec08.processor;

import com.renat.event_driven_playground.sec08.dto.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.UUID;
import java.util.function.Function;

@Configuration
public class ReactiveProcessorConfig {

    @Bean // 1-to-1 mapping
    public Function<Flux<Order>, Flux<Payment>> paymentProcessor() {
        return (Flux<Order> flux) -> flux.map((Order order) -> new Payment(order.id(), order.amount(), UUID.randomUUID()));
    }

    @Bean // 1-to-0/1: filter - spring cloud stream drops the message on null
    public Function<Flux<Order>, Flux<Shipment>> shipmentProcessor() {
        return (Flux<Order> flux) -> flux
                .filter((Order order) -> ProductType.PHYSICAL.equals(order.productType()))
                .map((Order order) -> new Shipment(order.id(), "FEDEX-" + order.id()));
    }

    @Bean // 1-to-N mapping
    public Function<Flux<Order>, Flux<Notification>> notificationProcessor() {
        return (Flux<Order> flux) -> flux
                .flatMap((Order order) -> Flux.just(
                        createSMSNotification(order),
                        createEmailNotification(order)
                ));
    }

    private Notification createSMSNotification(Order order) {
        return new Notification(order.id(), NotificationChannel.SMS, String.valueOf(+9_111_222_333L + order.customerId()));
    }

    private Notification createEmailNotification(Order order) {
        return new Notification(order.id(), NotificationChannel.EMAIL, "user.%d@gmail.com".formatted(order.customerId()));

    }


}
