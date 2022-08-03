package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.model.enums.ERoles;

@Entity
@Table(name = "role", catalog = "employee_management")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "name", length = 20)
	private ERoles name;

	public Role() {
	}
	
	public Role(ERoles name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ERoles getName() {
		return name;
	}

	public void setName(ERoles name) {
		this.name = name;
	}

}
