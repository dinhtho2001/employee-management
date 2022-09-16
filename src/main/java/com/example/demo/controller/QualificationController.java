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

import com.example.demo.dto.QualificationDTO;
import com.example.demo.payload.response.QualificationResponse;
import com.example.demo.service.IQualificationService;

@RestController
public class QualificationController {

	@Autowired
	private IQualificationService service;
	
	@GetMapping(value="/qualifications")
	public QualificationResponse all(@RequestParam("page") int page, @RequestParam("limit") int limit) {		
		return service.findAll(page, limit);
	}
	
	@GetMapping(value="/qualification/{id}")
	public QualificationDTO one(@PathVariable("id") Long id) {		
		return service.findOne(id);
	}
	
	@PostMapping(value="/qualification")
	public QualificationDTO create(@RequestBody QualificationDTO dto ) {		
		return service.create(dto);
	}
	
	@PutMapping(value="/qualification/{id}")
	public QualificationDTO update(@RequestBody QualificationDTO dto, @PathVariable("id") Long id) {
		dto.setQualId(id);
		return service.update(dto);
	}
	
	@DeleteMapping(value="/qualification/{id}")
	public String delete(@PathVariable("id") Long id) {		
		return service.delete(id);
	}
}
