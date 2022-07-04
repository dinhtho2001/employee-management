package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long empId;
	
	@Column(name = "fname")
	private String fname;
	
	@Column(name = "lname")
	private String lname;
	
	@Column(name = "gender")
	private Boolean gender;
	
	@Column(name = "age")
	private Date age;
	
	@Column(name = "contact_add")
	private String contactAdd;
	
	@Column(name = "emp_email")
	private String empEmail;
	
	@Column(name = "emp_pass")
	private String empPass;
	
	@OneToMany(mappedBy = "employeeLeave")
	private List<Leave> leaves = new ArrayList<>();

	@OneToMany(mappedBy = "employeeQualification")
	private List<Qualification>  qualifications= new ArrayList<>();
	
	@OneToMany(mappedBy = "employeePayroll")
	private List<Payroll> payrolls = new ArrayList<>();
	


}
