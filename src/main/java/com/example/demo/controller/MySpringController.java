package com.example.demo.controller;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON_VALUE;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class MySpringController {
	
	@GetMapping(value = "/get-list-stream", produces = APPLICATION_STREAM_JSON_VALUE)
	public Flux<Integer> getMyList(){
		List<Integer> it = IntStream.range(0, 30).boxed().collect(Collectors.toList());
		return Flux.fromIterable(it).delayElements(Duration.ofMillis(1000));
	}
	
}
