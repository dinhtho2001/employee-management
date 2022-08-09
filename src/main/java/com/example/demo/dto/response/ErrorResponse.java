package com.example.demo.dto.response;

import com.example.demo.dto.EmployeeDTO;

import lombok.Data;

@Data
public class ErrorResponse {

	private String message;
	private EmployeeDTO sysError;

}
