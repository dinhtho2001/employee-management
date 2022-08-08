package com.example.demo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class LeaveDTO {

	private Long leaveId;
	
	private Long employeeId;
	
	private Date date;
	
	private String reason;
	
}
