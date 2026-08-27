package com.renat.event_driven_playground.sec04.producer;

import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

@Component
public class PingProducer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(PingProducer.class);
    private static final String PING_OUT = "ping-out";
    private final StreamBridge streamBridge;

    public PingProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }


    @Override
    public void run(String... args) throws Exception {
        var process = new ProcessBuilder("ping", "-n", "10", "google.com")
                .redirectErrorStream(true)
                .start();
        try (var reader = process.inputReader()) {
            reader.lines()
                    .forEach((String line) -> {
                        log.info("sending: {}", line);
                        this.streamBridge.send(PING_OUT, line);
                    });
        }
    }
}
