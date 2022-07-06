package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.response.EmployeeResponse;
import com.example.demo.service.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private IEmployeeService iEmployeeService;
	
	@GetMapping(value="/employees")
	public EmployeeResponse all(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		
		return iEmployeeService.findAll(page, limit);
	}
	
	@GetMapping(value="/employee/{id}")
	public EmployeeDTO one(@PathVariable("id") Long id) {
		
		return iEmployeeService.findOne(id);
	}
	
	@PostMapping(value="/employee")
	public EmployeeDTO newEmployee(@RequestBody EmployeeDTO employeeDTO ) {
		
		return iEmployeeService.newEmployee(employeeDTO);
	}
	
	@PutMapping(value="/employee/{id}")
	public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO dto, @PathVariable("id") Long id) {
		dto.setEmpId(id);
		return iEmployeeService.updateEmployee(dto);
	}
	
	@DeleteMapping(value="/employee/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {
		
		return iEmployeeService.deleteEmployee(id);
	}
	
}
