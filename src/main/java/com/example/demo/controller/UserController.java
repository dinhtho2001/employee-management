package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.user.impl.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/login")
	public String login(@RequestBody User user) {
		return service.save(user);
	}
	
	@PostMapping("/logout")
	public String logout(@RequestBody User user) {
		return service.save(user);
	}
	
	@PostMapping("/register")
	public String create(@RequestBody User user) {
		return service.save(user);
	}

	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
//	@GetMapping
//	public User findByUsername(Integer id) {
//		return service.findById(id);
//	}
	
	@GetMapping("/user")
	public String user() {
		return "user";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}
}
