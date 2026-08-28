package com.renat.event_driven_playground.sec05.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

@Configuration
public class ReactiveProducerConfig {

    private static final Logger log = LoggerFactory.getLogger(ReactiveProducerConfig.class);


        @Bean
        public Supplier<Flux<String>> reactiveProducer() {
            return () -> Flux.interval(Duration.ofSeconds(1))
                    .map((Long i) -> "msg-" + i)
                    .doOnNext((String msg) -> log.info("sending: {}", msg));
        }
}
