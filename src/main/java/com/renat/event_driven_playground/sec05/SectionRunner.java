package com.renat.event_driven_playground.sec05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class SectionRunner {

    @SpringBootApplication(scanBasePackages = "com.renat.event_driven_playground.${section}.consumer")
    static class Consumer {

        public static void main(String[] args) {
            SpringApplication.run(Consumer.class,
                    "--section=sec05",
                    "--config=01-consumer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.renat.event_driven_playground.${section}.producer")
    static class Producer {

        public static void main(String[] args) {
            SpringApplication.run(
                    Producer.class,
                    "--section=sec05",
                    "--config=02-producer");
        }
    }


}
