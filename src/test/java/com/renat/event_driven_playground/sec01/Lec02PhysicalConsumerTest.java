package com.renat.event_driven_playground.sec01;

import com.renat.event_driven_playground.sec19.SectionRunner;
import com.renat.event_driven_playground.sec19.dto.DigitalDelivery;
import com.renat.event_driven_playground.sec19.dto.PhysicalDelivery;
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
                "config=02-physical-consumer"
        }
)
public class Lec02PhysicalConsumerTest extends AbstractTest {

    @Test
    public void digitalConsumer(CapturedOutput output) {
        var digitalDelivery = new PhysicalDelivery(1, "123 non main street", "atlanta");
        var message = MessageBuilder.withPayload(digitalDelivery).build();
        this.inputDestination.send(message, PHYSICAL_DELIVERY);

        Assertions.assertTrue(output.getOut().contains("received: " + digitalDelivery));

    }
}
