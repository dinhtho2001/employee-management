package com.example.demo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class QualificationDTO {

	private Long qualId;
	
	private Long emp_id;
	
	private String position;
	
	private String requirements;
	
	private Date dateIn;
	
}
