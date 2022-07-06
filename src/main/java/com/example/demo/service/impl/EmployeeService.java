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
	private EmployeeRepository  employeeRepository;

	@Autowired
	private EmployeeConverter employeeConverter ;

	@Override
	public EmployeeResponse findAll(int page, int limit) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setPage(page);
		Pageable pageable = PageRequest.of(page-1, limit);
		employeeResponse.setListResult(findAll(pageable));
		employeeResponse.setTotalPage((int)Math.ceil( (double) (totalTtem()) / limit));
		return employeeResponse;
	}
	
	@Override
	public int totalTtem() {
		return (int)employeeRepository.count();
	}

	@Override
	public EmployeeDTO findOne(Long id) {
		Employee employeeEntities = employeeRepository.findById(id).orElse(null);		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO = employeeConverter.toDTO(employeeEntities);
		return employeeDTO;
	}

	@Override
	public EmployeeDTO newEmployee(EmployeeDTO employeeDTO) {
		Employee employee = employeeConverter.toEntity(employeeDTO);
		Employee result = employeeRepository.save(employee);
		return employeeConverter.toDTO(result);
	}
	
	@Override
	public String deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		return "Delete success";
	}
	
	public List<EmployeeDTO> findAll(Pageable pageable){		
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		List<Employee> employeeEntities = employeeRepository.findAll(pageable).getContent();
		for(Employee item : employeeEntities) {
			EmployeeDTO employeeDTO = employeeConverter.toDTO(item);
			employeeDTOs.add(employeeDTO);
		}
		return employeeDTOs;
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
		Employee employee = employeeRepository.findById(employeeDTO.getEmpId()).orElse(null);
		Employee newEmployee = employeeConverter.toEntity(employeeDTO, employee);
		newEmployee = employeeRepository.save(newEmployee);
		return employeeConverter.toDTO(newEmployee);
	}
	
}
