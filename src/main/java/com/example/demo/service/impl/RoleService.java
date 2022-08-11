package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.RoleDTO;
import com.example.demo.dto.response.RoleResponse;
import com.example.demo.model.Employee;
import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.IRoleService;

@Service
public class RoleService implements IRoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public RoleResponse findAll() {
		try {
			List<Role> roles = roleRepository.findAll();
			List<RoleDTO> roleDTOs = new ArrayList<>();
			for (Role role : roles) {
				RoleDTO roleDTO = modelMapper.map(role, RoleDTO.class);
				roleDTOs.add(roleDTO);
			}
			RoleResponse response = new RoleResponse();
			response.setMessage("Success");
			response.setData(roleDTOs);
			response.setStatus("Ok");
			return response;
		} catch (Exception e) {
			return new RoleResponse();
		}
	}

	@Override
	public RoleResponse findById(Long id) {
		try {
			List<RoleDTO> roleDTOs = new ArrayList<>();
			Role role = roleRepository.findById(id).orElse(new Role());
			RoleDTO roleDTO = modelMapper.map(role, RoleDTO.class);
			roleDTOs.add(roleDTO);
			RoleResponse response = new RoleResponse();
			response.setMessage("Success");
			response.setData(roleDTOs);
			response.setStatus("Ok");
			return response;
		} catch (Exception e) {
			return new RoleResponse();
		}
	}

	@Override
	public RoleResponse updateById(RoleDTO dto) {
		try {
			Role role = roleRepository.findById(dto.getId()).orElse(new Role());
			RoleDTO roleDTO = new RoleDTO();
			if(role!= null) {
				roleRepository.save(role);
				roleDTO = modelMapper.map(role, RoleDTO.class);
			}
			List<RoleDTO> roleDTOs = new ArrayList<>();
			roleDTOs.add(roleDTO);
			RoleResponse response = new RoleResponse();
			response.setMessage("Success");
			response.setData(roleDTOs);
			response.setStatus("Ok");
			return response;
		} catch (Exception e) {
			return new RoleResponse();
		}
	}

	@Override
	public Boolean deleteById(Long id) {
		try {
			roleRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public RoleResponse create(RoleDTO dto) {
		try {
			Role role = modelMapper.map(dto, Role.class);
			Role result = roleRepository.save(role);
			RoleResponse response = new RoleResponse();
			if(result != null) {
				List<RoleDTO> roleDTOs = new ArrayList<>();
				roleDTOs.add(dto);
				response.setMessage("Success");
				response.setData(roleDTOs);
				response.setStatus("Ok");				
			}
			return response;
		} catch (Exception e) {
			return new RoleResponse();
		}

	}

}
