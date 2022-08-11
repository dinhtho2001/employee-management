package com.example.demo.service;

import com.example.demo.dto.RoleDTO;
import com.example.demo.dto.response.RoleResponse;

public interface IRoleService {

	RoleResponse findAll();
	RoleResponse findById(Long id);
	RoleResponse create(RoleDTO dto);
	RoleResponse updateById(RoleDTO roleDTO);
	Boolean deleteById(Long id);
}
