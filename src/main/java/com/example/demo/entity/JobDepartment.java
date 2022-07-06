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
	
	@OneToMany(mappedBy = "jobDepartmentId")
	private List<SalaryBonus> salaryBonus = new ArrayList<>();

	@OneToMany(mappedBy = "jobDepartmentId")
	private List<Payroll>  payrolls= new ArrayList<>();

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

	public List<SalaryBonus> getSalaryBonus() {
		return salaryBonus;
	}

	public void setSalaryBonus(List<SalaryBonus> salaryBonus) {
		this.salaryBonus = salaryBonus;
	}

	public List<Payroll> getPayrolls() {
		return payrolls;
	}

	public void setPayrolls(List<Payroll> payrolls) {
		this.payrolls = payrolls;
	}
	
}
