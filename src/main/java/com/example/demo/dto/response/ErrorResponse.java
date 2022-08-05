package com.example.demo.dto.response;

import com.example.demo.dto.UserDTO;

public class ErrorResponse {

	private String message;
	private UserDTO sysError;

	public ErrorResponse() {
	}

	public ErrorResponse(String message, UserDTO sysError) {
		super();
		this.message = message;
		this.sysError = sysError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserDTO getSysError() {
		return sysError;
	}

	public void setSysError(UserDTO sysError) {
		this.sysError = sysError;
	}

}
