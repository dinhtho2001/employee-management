package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users", catalog = "employee_management", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "username", unique = true, length = 45)
	private String username;

	@Column(name = "password")
	private String password;
	
	 @Column(name = "enabled", nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean enabled;
	 
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "users")
	private List<UsersRoles> usersRoleses = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<UsersRoles> getUsersRoleses() {
		return usersRoleses;
	}

	public void setUsersRoleses(List<UsersRoles> usersRoleses) {
		this.usersRoleses = usersRoleses;
	}
	
}
