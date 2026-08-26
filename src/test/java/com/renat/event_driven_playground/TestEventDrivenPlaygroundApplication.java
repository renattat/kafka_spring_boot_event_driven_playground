package com.renat.event_driven_playground;

import com.renat.event_driven_playground.sec01.SectionRunner;
import org.springframework.boot.SpringApplication;

public class TestEventDrivenPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.from(SectionRunner::main).with(TestcontainersConfiguration.class).run(args);
	}

}
