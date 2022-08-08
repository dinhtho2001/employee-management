package com.example.demo.dto.response;

import com.example.demo.dto.UserDTO;

import lombok.Data;

@Data
public class ErrorResponse {

	private String message;
	private UserDTO sysError;

}
