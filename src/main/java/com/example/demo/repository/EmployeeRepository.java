package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Employee findOneByEmpId(Long empId);
	Employee findOneByEmpId(Employee empId);
	Optional<Employee> findByEmpEmail(String email);
	Boolean existsByEmpEmail(String email);
}
