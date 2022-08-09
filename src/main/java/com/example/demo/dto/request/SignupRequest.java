package com.example.demo.dto.request;

import java.util.Date;
import java.util.Set;

import lombok.Data;

@Data
public class SignupRequest {
	private String fname;
	
	private String lname;
	
	private Boolean gender;
	
	private Date age;
	
	private String contactAdd;
	
	private String username;
	
	private String password;
	
	private Set<String> role;

}
