package com.renat.event_driven_playground.sec09.consumer;

import com.renat.event_driven_playground.sec09.dto.DigitalDelivery;
import com.renat.event_driven_playground.sec09.dto.PhysicalDelivery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class PhysicalDeliveryConsumer {

    private static final Logger log = LoggerFactory.getLogger(PhysicalDeliveryConsumer.class);

    @Bean
    public Consumer<PhysicalDelivery> physicalConsumer() {
        return (PhysicalDelivery msg) -> log.info("received: {}", msg);
    }

}
