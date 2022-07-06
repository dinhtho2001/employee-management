package com.example.demo.dto;

import java.util.Date;

public class EmployeeDTO {

	private Long empId;
	
	private String fname;
	
	private String lname;
	
	private Boolean gender;
	
	private Date age;
	
	private String contactAdd;
	
	private String empEmail;
	
	private String empPass;

	
	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Date getAge() {
		return age;
	}

	public void setAge(Date age) {
		this.age = age;
	}

	public String getContactAdd() {
		return contactAdd;
	}

	public void setContactAdd(String contactAdd) {
		this.contactAdd = contactAdd;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPass() {
		return empPass;
	}

	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}
	
	
}
