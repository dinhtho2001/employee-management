package com.example.demo.dto;

import com.example.demo.model.enums.ERoles;

import lombok.Data;

@Data
public class RoleDTO {
	
	private Long id;
	private ERoles name;
}
