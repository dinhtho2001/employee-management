package com.example.demo.dto;

public class UserDTO {

	private Long id;
	private String username;
	private Boolean enabled;
	
	public UserDTO() {
		
	}

	public UserDTO(Long id, String username, Boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.enabled = enabled;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
}
