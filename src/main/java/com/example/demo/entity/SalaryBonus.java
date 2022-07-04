package com.example.demo.entity;

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
	private JobDepartment jobDepartmentSalaryBonus;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "anual")
	private String anual;
	
	@Column(name = "bonus")
	private Double bonus;
	
	@OneToMany(mappedBy = "salaryBonusPayroll")
	private List<Payroll> payrolls = new ArrayList<>();
	
	
}
