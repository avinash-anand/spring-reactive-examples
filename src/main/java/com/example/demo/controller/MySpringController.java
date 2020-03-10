package com.example.demo.controller;

import static org.springframework.http.MediaType.*;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class MySpringController {

	private final EmployeeService employeeService;
	@GetMapping(value = "/get-list-stream", produces = APPLICATION_STREAM_JSON_VALUE)
	public Flux<Integer> getMyList(){
		List<Integer> it = IntStream.range(0, 30).boxed().collect(Collectors.toList());
		return Flux.fromIterable(it).delayElements(Duration.ofMillis(1000));
	}
	
	@GetMapping(value = "/get-all-emp", produces = APPLICATION_JSON_VALUE)
	public Flux<Employee> getAllEmp() {
		return employeeService.getAllMyWay();
	}
	
	@GetMapping(value = "/get-all-emp-data", produces = APPLICATION_JSON_VALUE)
	public Flux<Employee> getAllEmpData() {
		return employeeService.getAllByData();
	}
	
}
