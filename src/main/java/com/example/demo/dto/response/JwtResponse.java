package com.example.demo.dto.response;

import java.util.List;

import lombok.Data;

@Data
public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private Integer id;
	private String username;
	private List<String> roles;
	
}
