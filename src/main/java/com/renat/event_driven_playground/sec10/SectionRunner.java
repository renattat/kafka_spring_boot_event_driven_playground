package com.renat.event_driven_playground.sec10;

import com.renat.event_driven_playground.sec09.consumer.PhysicalDeliveryConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


public class SectionRunner {

    @SpringBootApplication(scanBasePackages = "com.renat.event_driven_playground.${section}.consumer")
    static class DigitalDeliveryConsumer {

        public static void main(String[] args) {
            SpringApplication.run(DigitalDeliveryConsumer.class,
                    "--section=sec10",
                    "--config=01-digital-consumer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.renat.event_driven_playground.${section}.consumer")
    static class FedExConsumer {

        public static void main(String[] args) {
            SpringApplication.run(FedExConsumer.class,
                    "--section=sec10",
                    "--config=02-fedex-consumer");
        }
    }

    @SpringBootApplication(scanBasePackages = "com.renat.event_driven_playground.${section}.consumer")
    static class USPSConsumer {

        public static void main(String[] args) {
            SpringApplication.run(USPSConsumer.class,
                    "--section=sec10",
                    "--config=03-usps-consumer");
        }
    }

    @EnableScheduling
    @SpringBootApplication(scanBasePackages = "com.renat.event_driven_playground.${section}.processor")
    static class Processor {

        public static void main(String[] args) {
            SpringApplication.run(Processor.class,
                    "--section=sec10",
                    "--config=04-processor");
        }
    }


    @SpringBootApplication(scanBasePackages = "com.renat.event_driven_playground.${section}.producer")
    static class Producer {

        public static void main(String[] args) {
            SpringApplication.run(
                    Producer.class,
                    "--section=sec10",
                    "--config=05-producer");
        }
    }


}
