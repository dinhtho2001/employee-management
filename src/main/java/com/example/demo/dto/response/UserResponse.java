package com.example.demo.dto.response;

import java.util.List;

import com.example.demo.dto.EmployeeDTO;

import lombok.Data;

@Data
public class UserResponse {

	private String message;
	private List<EmployeeDTO> data;
	private String status;

}
