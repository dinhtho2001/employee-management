package com.example.demo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PayrollDTO {

	private Long payrollId;
	
	private Long emp_id;
	
	private Long job_id;
	
	private Long salary_id;
	
	private Long leave_id;
	
	private Date date;
	
	private String report;
	
	private Double totalAmount;

}
