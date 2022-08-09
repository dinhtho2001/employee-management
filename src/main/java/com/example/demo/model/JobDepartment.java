package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "job_department")
public class JobDepartment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id")
	private Long jobId;
	
	@Column(name = "job_dept")
	private String jopDept;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "salary_range")
	private Float salaryRange;
	
	@OneToMany(mappedBy = "jobDepartmentId")
	private List<Salary> salaryBonus = new ArrayList<>();

	@OneToMany(mappedBy = "jobDepartmentId")
	private List<Payroll>  payrolls= new ArrayList<>();

}
