package com.example.demo.dto;

import java.util.Date;


public class QualificationDTO {

	private Long qualId;
	
	private Long emp_id;
	
	private String position;
	
	private String requirements;
	
	private Date dateIn;

	public Long getQualId() {
		return qualId;
	}

	public void setQualId(Long qualId) {
		this.qualId = qualId;
	}

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public Date getDateIn() {
		return dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}
	
	
}
