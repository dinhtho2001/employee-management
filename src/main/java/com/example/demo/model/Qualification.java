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

}
