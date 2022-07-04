package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "jobdepartment")
public class JobDepartment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jop_id")
	private Long jobId;
	
	@Column(name = "jop_dept")
	private String jopDept;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "salary_range")
	private String salaryRange;
	
	@OneToMany(mappedBy = "jobDepartmentSalaryBonus")
	private List<SalaryBonus> salaryBonus = new ArrayList<>();

	@OneToMany(mappedBy = "jobDepartmentPayroll")
	private List<Payroll>  payrolls= new ArrayList<>();
	

	
}
