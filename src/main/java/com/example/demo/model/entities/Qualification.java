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
@Table (name = "qualification")
public class Qualification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "qual_id")
	private Long qualId;
	
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee employeeId;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "requirements")
	private String requirements;
	
	@Column(name = "date_in")
	private Date dateIn;

	public Long getQualId() {
		return qualId;
	}

	public void setQualId(Long qualId) {
		this.qualId = qualId;
	}


	public Employee getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public Date getDateIn() {
		return dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}
	
	
}
