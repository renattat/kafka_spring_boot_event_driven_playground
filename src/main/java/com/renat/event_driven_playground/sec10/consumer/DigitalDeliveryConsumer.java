package com.renat.event_driven_playground.sec10.consumer;

import com.renat.event_driven_playground.sec10.dto.DigitalDelivery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class DigitalDeliveryConsumer {

    private static final Logger log = LoggerFactory.getLogger(DigitalDeliveryConsumer.class);

    @Bean
    public Consumer<DigitalDelivery> digitalConsumer() {
        return (DigitalDelivery msg) -> log.info("received: {}", msg);
    }

}
