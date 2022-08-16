package com.example.demo.dto.request;

import lombok.Data;

@Data
public class SignupRequest {
	private String fname;
	
	private String lname;
	
	private String gender;
	
	private String birthday;
	
	private String phone;
	
	private String email;
	
	private String password;
	
	private String role;

}
