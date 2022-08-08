package com.example.demo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeDTO {

	private Long empId;
	
	private String fname;
	
	private String lname;
	
	private Boolean gender;
	
	private Date age;
	
	private String contactAdd;
	
	private String empEmail;
	
	private String empPass;

}
