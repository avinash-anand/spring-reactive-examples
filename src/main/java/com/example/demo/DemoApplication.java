package com.example.demo;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.scheduler.Schedulers;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	//helpful for MDC
	public void schedulerHook() {
		//TODO: https://ttddyy.github.io/mdc-with-webclient-in-webmvc/
		Schedulers.onScheduleHook("MDC", runnable -> {
			String requestId = MDC.get("requestId");
			return () -> {
				MDC.put("requestId", requestId);
				try {
					runnable.run();
				} finally {
					MDC.remove("requestId");
				}
			};
		});
	}

}
