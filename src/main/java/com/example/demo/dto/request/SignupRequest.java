package com.example.demo.dto.request;

import java.util.Set;

import lombok.Data;

@Data
public class SignupRequest {
	private String username;
	
	private String password;
	
	private Set<String> role;
	
	private Boolean enabled;

}
