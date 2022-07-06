package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.response.EmployeeResponse;
import com.example.demo.entity.Employee;

public interface IEmployeeService {
	
	EmployeeResponse findAll(int page, int limit);
	int totalTtem();
	EmployeeDTO findOne(Long id);
	EmployeeDTO newEmployee(EmployeeDTO employeeDTO);
	EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
	String deleteEmployee(Long id);
}
