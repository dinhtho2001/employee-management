package com.example.demo.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "salarybonus")
public class SalaryBonus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "salary_id")
	private Long salaryId;
	
	@ManyToOne
	@JoinColumn(name = "job_id")
	private JobDepartment jobDepartmentId;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "anual")
	private String anual;
	
	@Column(name = "bonus")
	private Double bonus;
	
	@OneToMany(mappedBy = "salaryBonusId")
	private List<Payroll> payrolls = new ArrayList<>();

	public Long getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(Long salaryId) {
		this.salaryId = salaryId;
	}

	

	public JobDepartment getJobDepartmentId() {
		return jobDepartmentId;
	}

	public void setJobDepartmentId(JobDepartment jobDepartmentId) {
		this.jobDepartmentId = jobDepartmentId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getAnual() {
		return anual;
	}

	public void setAnual(String anual) {
		this.anual = anual;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	public List<Payroll> getPayrolls() {
		return payrolls;
	}

	public void setPayrolls(List<Payroll> payrolls) {
		this.payrolls = payrolls;
	}
	
	
}
