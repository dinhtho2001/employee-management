package com.example.demo.dto.response;

import java.util.List;

import com.example.demo.dto.EmployeeDTO;

import lombok.Data;

@Data
public class EmployeeResponse {
	private int page;
	private int total_page;
	private List<EmployeeDTO> employees;
	
}
