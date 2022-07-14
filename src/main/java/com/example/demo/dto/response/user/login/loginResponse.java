package com.example.demo.dto.response.user.login;

import java.util.List;

import com.example.demo.dto.user.UserDTO;

public class loginResponse {

	private String title; 
	private List<UserDTO> data; 
	private String statuscode;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<UserDTO> getData() {
		return data;
	}
	public void setData(List<UserDTO> data) {
		this.data = data;
	}
	public String getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}

}
