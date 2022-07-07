package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.response.EmployeeResponse;

public interface IEmployeeService {
	
	EmployeeResponse findAll(int page, int limit);
	int totalTtem();
	EmployeeDTO findOne(Long id);
	EmployeeDTO create(EmployeeDTO employeeDTO);
	EmployeeDTO update(EmployeeDTO employeeDTO);
	String delete(Long id);
	String deletes(Long[] ids);
}
