package com.example.demo.dto.response;

import java.util.List;

import com.example.demo.dto.user.UserDTO;

public class UserResponse {

	private String message;
	private List<UserDTO> data;
	private String status;

	public UserResponse() {

	}

	public UserResponse(String message, List<UserDTO> data, String status) {
		super();
		this.message = message;
		this.data = data;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<UserDTO> getData() {
		return data;
	}

	public void setData(List<UserDTO> data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
