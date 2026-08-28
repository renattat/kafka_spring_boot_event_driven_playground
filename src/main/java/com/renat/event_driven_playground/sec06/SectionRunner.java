package com.renat.event_driven_playground.sec06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class SectionRunner {

    @SpringBootApplication(scanBasePackages = "com.renat.event_driven_playground.${section}.consumer")
    static class Consumer1 {

        public static void main(String[] args) {
            SpringApplication.run(Consumer1.class,
                    "--section=sec06",
                    "--config=01-consumer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.renat.event_driven_playground.${section}.consumer")
    static class Consumer2 {

        public static void main(String[] args) {
            SpringApplication.run(Consumer2.class,
                    "--section=sec06",
                    "--config=01-consumer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.renat.event_driven_playground.${section}.consumer")
    static class Consumer3 {

        public static void main(String[] args) {
            SpringApplication.run(Consumer3.class,
                    "--section=sec06",
                    "--config=01-consumer");
        }
    }


    @SpringBootApplication(scanBasePackages = "com.renat.event_driven_playground.${section}.producer")
    static class Producer {

        public static void main(String[] args) {
            SpringApplication.run(
                    Producer.class,
                    "--section=sec06",
                    "--config=02-producer");
        }
    }


}
