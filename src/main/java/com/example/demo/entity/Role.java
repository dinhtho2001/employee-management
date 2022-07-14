package com.example.demo.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role", catalog = "employee_management")
public class Role {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "name", length = 45)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	private List<UsersRoles> usersRoleses = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UsersRoles> getUsersRoleses() {
		return usersRoleses;
	}

	public void setUsersRoleses(List<UsersRoles> usersRoleses) {
		this.usersRoleses = usersRoleses;
	}
	
}
