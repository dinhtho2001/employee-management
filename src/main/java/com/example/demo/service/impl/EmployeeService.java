package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.example.demo.converter.EmployeeConverter;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.response.EmployeeResponse;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService{

	@Autowired
	private EmployeeRepository repository;

	@Autowired
	private EmployeeConverter converter ;

	@Override
	public EmployeeResponse findAll(int page, int limit) {
		EmployeeResponse response = new EmployeeResponse();
		try {
			Pageable pageable = PageRequest.of(page-1, limit);
			response.setListResult(findAll(pageable));
		} catch (Exception e) {
			return null;
		}
		finally {
			response.setPage(page);
			response.setTotalPage((int)Math.ceil( (double) (totalTtem()) / limit));
			
		}
		return response;
	}
	
	@Override
	public EmployeeDTO findOne(Long id) {
		try {
			Employee employee = repository.findById(id).orElse(null);	
			EmployeeDTO dto = new EmployeeDTO();
			dto = converter.toDTO(employee);
			return dto;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public int totalTtem() {
		try {
			return (int)repository.count();
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public EmployeeDTO create(EmployeeDTO employeeDTO) {
		Employee employee = converter.toEntity(employeeDTO);
		Employee result = repository.save(employee);
		return converter.toDTO(result);
	}
	
	public List<EmployeeDTO> findAll(Pageable pageable){		
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		List<Employee> employees = repository.findAll(pageable).getContent();
		for(Employee item : employees) {
			EmployeeDTO dto = converter.toDTO(item);
			employeeDTOs.add(dto);
		}
		return employeeDTOs;
	}

	@Override
	public EmployeeDTO update(EmployeeDTO employeeDTO) {
		try {
			Employee employee = repository.findById(employeeDTO.getEmpId()).orElse(null);
			Employee entitis = converter.toEntity(employeeDTO, employee);
			entitis = repository.save(entitis);
			return converter.toDTO(entitis);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public String delete(Long id) {
		try {
			repository.deleteById(id);
			return "Delete success";
		} catch (Exception e) {
			return "Delete failed";
		}
	}
	
	@Override
	public String deletes(Long[] ids) {
		try {
			for (long item : ids) {
				repository.deleteById(item);
			}
			return "Delete success";
		} catch (Exception e) {
			return "Delete failed";
		}
	}
	
	
}
