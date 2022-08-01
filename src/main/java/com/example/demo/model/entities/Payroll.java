package com.example.demo.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "payroll")
public class Payroll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payroll_id")
	private Long payrollId;
	
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee employeeId;
	
	@ManyToOne
	@JoinColumn(name = "job_id")
	private JobDepartment jobDepartmentId;
	
	@ManyToOne
	@JoinColumn(name = "salary_id")
	private SalaryBonus salaryBonusId;
	
	@ManyToOne
	@JoinColumn(name = "leave_id")
	private Leave leaveId;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "report")
	private String report;
	
	@Column(name = "total_amount")
	private Double totalAmount;

	public Long getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(Long payrollId) {
		this.payrollId = payrollId;
	}



	public Employee getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}

	public JobDepartment getJobDepartmentId() {
		return jobDepartmentId;
	}

	public void setJobDepartmentId(JobDepartment jobDepartmentId) {
		this.jobDepartmentId = jobDepartmentId;
	}

	public SalaryBonus getSalaryBonusId() {
		return salaryBonusId;
	}

	public void setSalaryBonusId(SalaryBonus salaryBonusId) {
		this.salaryBonusId = salaryBonusId;
	}

	public Leave getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Leave leaveId) {
		this.leaveId = leaveId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	

	
}
