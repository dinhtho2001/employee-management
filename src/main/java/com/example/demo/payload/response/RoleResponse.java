package com.example.demo.payload.response;

import java.util.List;

import com.example.demo.dto.RoleDTO;

import lombok.Data;

@Data
public class RoleResponse {
	private String message;
	private List<RoleDTO> data;
    private String status;
}
