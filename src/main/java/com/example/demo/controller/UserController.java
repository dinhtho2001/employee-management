package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IUserService service;
	@PostMapping("/register")
	public String create(@RequestBody User user) {
		return null;
	}

	@GetMapping
	public List<UserDTO> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{username}")
	public UserDTO findByUsername(@PathVariable("username") String username) {
		return service.findByUsername(username);
	}
}
