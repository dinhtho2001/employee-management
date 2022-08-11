package com.example.demo.service;

import java.io.IOException;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.response.EmployeeResponse;

public interface IEmployeeService {
	
	EmployeeResponse findAll(int page, int limit);
	int totalTtem();
	EmployeeDTO findOne(Long id);
	EmployeeDTO[] creates (EmployeeDTO[] dtos);
	EmployeeDTO create(EmployeeDTO dto);
	EmployeeDTO update(EmployeeDTO dto);
	Boolean delete(Long id);
	Boolean deletes(Long[] ids);
	
	Boolean saveEmployeesToExcel(String fileName)throws IOException;
}
