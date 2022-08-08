package com.example.demo.dto.response;

import java.util.List;

import com.example.demo.dto.UserDTO;

import lombok.Data;

@Data
public class UserResponse {

	private String message;
	private List<UserDTO> data;
	private String status;

}
