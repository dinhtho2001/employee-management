package com.example.demo.dto;


public class JobDepartmentDTO {

	private Long jobId;
	
	private String jopDept;
	
	private String name;
	
	private String description;
	
	private String salaryRange;

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJopDept() {
		return jopDept;
	}

	public void setJopDept(String jopDept) {
		this.jopDept = jopDept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSalaryRange() {
		return salaryRange;
	}

	public void setSalaryRange(String salaryRange) {
		this.salaryRange = salaryRange;
	}
	
	
}
