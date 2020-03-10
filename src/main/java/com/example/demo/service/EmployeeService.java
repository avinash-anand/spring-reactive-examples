package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeMyRepository;
import com.example.demo.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	private final EmployeeMyRepository employeeMyRepository;
	private final EmployeeRepository employeeRepository;

	public Flux<Employee> getAllMyWay() {
		return employeeMyRepository.getAll();
	}

	public Flux<Employee> getAllByData() {
		return employeeRepository.findAll();
	}
	
	//TODO: @Transactional - show roll-back as well
	//TODO: show stored-procedure or function call if possible

}
