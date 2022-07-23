package com.example.demo.dto.response;

import java.util.List;

public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private String id;
	private String username;
	private Boolean enabled;
	private List<String> roles;
	
	public JwtResponse(String token, String id, String username, Boolean enabled, List<String> roles) {
		super();
		this.token = token;
		this.id = id;
		this.username = username;
		this.enabled = enabled;
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
		
}
