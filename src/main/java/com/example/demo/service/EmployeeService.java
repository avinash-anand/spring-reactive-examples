package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeMyRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	private final EmployeeMyRepository employeeMyRepository;

	@Transactional
	public Flux<Employee> getAll() {
		return employeeMyRepository.getAll();
	}

}
