package com.example.demo.payload.response;

import lombok.Data;

@Data
public class JwtResponse {
	private Integer id;
	private String email;
	private Object roles;
	private String access_token;
	private String token_type;
	
}
