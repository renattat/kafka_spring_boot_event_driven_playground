package com.renat.event_driven_playground.sec13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class SectionRunner {

	@SpringBootApplication(scanBasePackages = "com.renat.event_driven_playground.${section}.consumer")
	static class DigitalDeliveryConsumer {

		public static void main(String[] args) {
			SpringApplication.run(com.renat.event_driven_playground.sec13.SectionRunner.DigitalDeliveryConsumer.class,
					"--section=sec13",
					"--config=01-digital-consumer");
		}

	}

	@SpringBootApplication(scanBasePackages = "com.renat.event_driven_playground.${section}.consumer")
	static class PhysicalDeliveryConsumer {

		public static void main(String[] args) {
			SpringApplication.run(PhysicalDeliveryConsumer.class, "--section=sec13", "--config=02-physical-consumer");
		}

	}

	@SpringBootApplication(scanBasePackages = "com.renat.event_driven_playground.${section}.processor")
	static class Processor {

		public static void main(String[] args) {
			SpringApplication.run(Processor.class, "--section=sec13", "--config=03-processor");
		}

	}

	@SpringBootApplication(scanBasePackages = "com.renat.event_driven_playground.${section}.producer")
	static class Producer {

		public static void main(String[] args) {
			SpringApplication.run(Producer.class, "--section=sec13", "--config=04-producer");
		}

	}

}
