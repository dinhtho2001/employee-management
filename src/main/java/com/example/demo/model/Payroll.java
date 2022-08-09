package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
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
	private Salary salaryBonusId;
	
	@ManyToOne
	@JoinColumn(name = "leave_id")
	private Leave leaveId;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "report")
	private String report;
	
	@Column(name = "total_amount")
	private Double totalAmount;
	
}
