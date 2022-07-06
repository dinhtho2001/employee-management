package com.example.demo.entity;

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
	private Employee employeePayroll;
	
	@ManyToOne
	@JoinColumn(name = "job_id")
	private JobDepartment jobDepartmentPayroll;
	
	@ManyToOne
	@JoinColumn(name = "salary_id")
	private SalaryBonus salaryBonusPayroll;
	
	@ManyToOne
	@JoinColumn(name = "leave_id")
	private Leave leavePayroll;
	
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

	public Employee getEmployeePayroll() {
		return employeePayroll;
	}

	public void setEmployeePayroll(Employee employeePayroll) {
		this.employeePayroll = employeePayroll;
	}

	public JobDepartment getJobDepartmentPayroll() {
		return jobDepartmentPayroll;
	}

	public void setJobDepartmentPayroll(JobDepartment jobDepartmentPayroll) {
		this.jobDepartmentPayroll = jobDepartmentPayroll;
	}

	public SalaryBonus getSalaryBonusPayroll() {
		return salaryBonusPayroll;
	}

	public void setSalaryBonusPayroll(SalaryBonus salaryBonusPayroll) {
		this.salaryBonusPayroll = salaryBonusPayroll;
	}

	public Leave getLeavePayroll() {
		return leavePayroll;
	}

	public void setLeavePayroll(Leave leavePayroll) {
		this.leavePayroll = leavePayroll;
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
