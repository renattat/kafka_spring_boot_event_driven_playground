package com.renat.event_driven_playground.sec01;

import com.renat.event_driven_playground.sec19.SectionRunner;
import com.renat.event_driven_playground.sec19.dto.DigitalDelivery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.messaging.support.MessageBuilder;

@ExtendWith(OutputCaptureExtension.class) // helps to check the log
@SpringBootTest(
        classes = SectionRunner.DigitalDeliveryConsumer.class,
        properties = {
                "section=sec19",
                "config=01-digital-consumer"

        }
)
public class Lec01DigitalConsumerTest extends AbstractTest {

    @Test
    public void digitalConsumer(CapturedOutput output) {
        var digitalDelivery = new DigitalDelivery(1, "sam@Gmail.com");
        var message = MessageBuilder.withPayload(digitalDelivery).build();
        this.inputDestination.send(message, DIGITAL_DELIVERY);

        Assertions.assertTrue(output.getOut().contains("received: " + digitalDelivery));

    }
}
