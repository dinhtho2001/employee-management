package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Employee findOneByEmpId(Long empId);
	Employee findOneByEmpId(Employee empId);
	//@Query("")//JPQL
	//Employee test();
}
