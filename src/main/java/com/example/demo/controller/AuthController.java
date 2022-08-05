package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.request.SignupRequest;
import com.example.demo.dto.response.JwtResponse;
import com.example.demo.dto.response.MessageResponse;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.AuthService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthService authService;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;

	@PostMapping("/signin")
	public ResponseEntity<?> signin(@RequestBody LoginRequest loginRequest) {
		JwtResponse jwtResponse = authService.signin(loginRequest);
		if (jwtResponse != null) {
			return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("not found", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
		if (authService.signup(signupRequest) != null) {
			return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		} else {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}
	}

}
