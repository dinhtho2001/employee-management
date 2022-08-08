package com.example.demo.dto.response;

import java.util.List;

import lombok.Data;

@Data
public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private String id;
	private String username;
	private Boolean enabled;
	private List<String> roles;
}
