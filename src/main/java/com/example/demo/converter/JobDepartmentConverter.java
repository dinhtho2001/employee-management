package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.dto.JobDepartmentDTO;
import com.example.demo.model.entities.JobDepartment;

@Component
public class JobDepartmentConverter {
	public JobDepartment toEntity(JobDepartmentDTO dto) {
		JobDepartment entity = new JobDepartment();
		entity.setJopDept(dto.getJopDept());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setSalaryRange(dto.getSalaryRange());
		return entity;
	}
	
	public JobDepartment toEntity(JobDepartmentDTO dto, JobDepartment entity) {
		entity.setJopDept(dto.getJopDept());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setSalaryRange(dto.getSalaryRange());
		return entity;
	}
	
	public JobDepartmentDTO toDTO(JobDepartment entity) {
		JobDepartmentDTO dto = new JobDepartmentDTO();
		dto.setJobId(entity.getJobId());
		dto.setJopDept(entity.getJopDept());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setSalaryRange(entity.getSalaryRange());
		return dto;
	}
}
