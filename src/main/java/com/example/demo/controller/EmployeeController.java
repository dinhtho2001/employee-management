package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.response.EmployeeResponse;
import com.example.demo.service.IEmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	@GetMapping
	public EmployeeResponse all(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		
		return service.findAll(page, limit);
	}
	
	@GetMapping(value="/{id}")
	public EmployeeDTO one(@PathVariable("id") Long id) {
		
		return service.findOne(id);
	}
	
	@PostMapping
	public EmployeeDTO[] creates(@RequestBody EmployeeDTO[] dtos ) {
		
		return service.creates(dtos);
	}
	@PostMapping
	public EmployeeDTO create(@RequestBody EmployeeDTO dto ) {
		
		return service.create(dto);
	}
	
	@PutMapping(value="/{id}")
	public EmployeeDTO update(@RequestBody EmployeeDTO dto, @PathVariable("id") Long id) {
		dto.setEmpId(id);
		return service.update(dto);
	}
	
	@DeleteMapping(value="/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		return service.delete(id);
	}
	
	@DeleteMapping
	public String deletes(@RequestBody Long[] ids) {
		
		return service.deletes(ids);
	}
	
}
