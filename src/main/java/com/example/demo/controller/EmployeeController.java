package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin
@RestController
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	@GetMapping(value="/employees")
	public EmployeeResponse all(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		
		return service.findAll(page, limit);
	}
	
	@GetMapping(value="/employee/{id}")
	public EmployeeDTO one(@PathVariable("id") Long id) {
		
		return service.findOne(id);
	}
	
	@PostMapping(value="/employee")
	public EmployeeDTO create(@RequestBody EmployeeDTO dto ) {
		
		return service.create(dto);
	}
	
	@PutMapping(value="/employee/{id}")
	public EmployeeDTO update(@RequestBody EmployeeDTO dto, @PathVariable("id") Long id) {
		dto.setEmpId(id);
		return service.update(dto);
	}
	
	@DeleteMapping(value="/employee/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		return service.delete(id);
	}
	
}
