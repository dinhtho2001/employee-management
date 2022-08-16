package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RoleDTO;
import com.example.demo.dto.response.ErrorResponse;
import com.example.demo.dto.response.RoleResponse;
import com.example.demo.exception.SysError;
import com.example.demo.service.IRoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

	@Autowired
	private IRoleService roleService;
	
	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> findAll() {
		RoleResponse response = roleService.findAll();
		if (response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("False");
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		RoleResponse response = roleService.findById(id);
		if (response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("False");
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> createRole(@RequestBody RoleDTO dto) {
		RoleResponse response = roleService.create(dto);
		if (response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("False");
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> updateById(@RequestBody RoleDTO dto, @PathVariable("id") Long id) {
		dto.setId(id);
		RoleResponse response = roleService.updateById(dto);
		if (response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Bad Request",new SysError()));
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		if(roleService.deleteById(id)) {
			return ResponseEntity.ok("Success");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("False");
		
	}
}
