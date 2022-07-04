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

	
}
