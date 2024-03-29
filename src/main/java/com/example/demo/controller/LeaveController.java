package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LeaveDTO;
import com.example.demo.payload.response.LeaveResponse;
import com.example.demo.service.ILeaveService;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

	@Autowired
	private ILeaveService service;
	
	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public LeaveResponse findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {		
		return service.findAll(page, limit);
	}
	
	@GetMapping(value="/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public LeaveDTO findOneById(@PathVariable("id") Long id) {		
		return service.findOne(id);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public LeaveDTO create(@RequestBody LeaveDTO dto ) {		
		return service.create(dto);
	}
	
	@PutMapping(value="/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public LeaveDTO update(@RequestBody LeaveDTO dto, @PathVariable("id") Long id) {
		dto.setLeaveId(id);
		return service.update(dto);
	}
	
	@DeleteMapping(value="/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String delete(@PathVariable("id") Long id) {		
		return service.delete(id);
	}
}
