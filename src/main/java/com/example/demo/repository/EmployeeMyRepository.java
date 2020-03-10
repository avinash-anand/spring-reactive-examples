package com.example.demo.repository;

import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Employee;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class EmployeeMyRepository {
	private final DatabaseClient databaseClient;
	
	public Flux<Employee> getAll() {
		return databaseClient.execute("SELECT * from employee")
		.map(row -> {
			Employee e = new Employee();
			e.setId(row.get("id", Long.class));
			e.setFirstName(row.get("first_name", String.class));
			e.setLastName(row.get("first_name", String.class));
			return e;
		}).all();
	}

}
