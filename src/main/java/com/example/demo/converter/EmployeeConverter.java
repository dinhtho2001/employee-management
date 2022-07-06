package com.example.demo.converter;

import org.springframework.stereotype.Component;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;

@Component
public class EmployeeConverter {

	public Employee toEntity(EmployeeDTO dto) {
		Employee entity = new Employee();
		entity.setFname(dto.getFname());
		entity.setLname(dto.getLname());
		entity.setGender(dto.getGender());
		entity.setAge(dto.getAge());
		entity.setContactAdd(dto.getContactAdd());
		entity.setEmpEmail(dto.getEmpEmail());
		entity.setEmpPass(dto.getEmpPass());
		return entity;
	}
	
	public Employee toEntity(EmployeeDTO dto, Employee entity) {
		entity.setEmpId(dto.getEmpId());
		entity.setFname(dto.getFname());
		entity.setLname(dto.getLname());
		entity.setGender(dto.getGender());
		entity.setAge(dto.getAge());
		entity.setContactAdd(dto.getContactAdd());
		entity.setEmpEmail(dto.getEmpEmail());
		entity.setEmpPass(dto.getEmpPass());
		return entity;
	}
	
	public EmployeeDTO toDTO(Employee entity) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpId(entity.getEmpId());
		dto.setFname(entity.getFname());
		dto.setLname(entity.getLname());
		dto.setGender(entity.getGender());
		dto.setAge(entity.getAge());
		dto.setContactAdd(entity.getContactAdd());
		dto.setEmpEmail(entity.getEmpEmail());
		dto.setEmpPass(entity.getEmpPass());
		return dto;
	}
}
