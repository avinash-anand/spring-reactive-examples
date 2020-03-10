package com.example.demo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Employee;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long>{

}
