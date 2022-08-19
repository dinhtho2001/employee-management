package com.example.demo.model;

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

import lombok.Data;

@Data
@Entity
@Table(name = "emp_leave")
public class Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "leave_id")
	private Long leaveId;
	
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee employeeId;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "reason")
	private String reason;
	
	@OneToMany(mappedBy = "leaveId")
	private List<Payroll> payrolls;

}
