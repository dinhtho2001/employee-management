package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "empleave")
public class Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "leave_id")
	private Long leaveId;
	
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee employeeLeave;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "reason")
	private String reason;
	
	@OneToMany(mappedBy = "leavePayroll")
	private List<Payroll> payrolls = new ArrayList<>();

	
}
