package com.example.demo.dto;

import java.util.Date;

import com.example.demo.entity.Employee;

public class LeaveDTO {

	private Long leaveId;
	
	private Employee employeeLeave;
	
	private Date date;
	
	private String reason;

	public Long getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}

	public Employee getEmployeeLeave() {
		return employeeLeave;
	}

	public void setEmployeeLeave(Employee employeeLeave) {
		this.employeeLeave = employeeLeave;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
