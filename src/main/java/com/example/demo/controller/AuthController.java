package com.example.demo.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.exception.ErrorParam;
import com.example.demo.exception.SysError;
import com.example.demo.payload.request.LoginRequest;
import com.example.demo.payload.request.SignupRequest;
import com.example.demo.payload.response.ErrorResponse;
import com.example.demo.payload.response.JwtResponse;
import com.example.demo.payload.response.SuccessReponse;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.IAuthService;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	IAuthService authService;
	
	@Autowired
	RoleRepository roleRepository;

	@PostMapping("/signin")
	public ResponseEntity<?> signin(@RequestBody LoginRequest loginRequest) {
		JwtResponse jwtResponse = authService.signin(loginRequest);
		if (jwtResponse.getEmail() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					new ErrorResponse(HttpStatus.BAD_REQUEST.name(), new SysError("email-not-found", new ErrorParam()))
					);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new SuccessReponse("success", jwtResponse, HttpStatus.OK.name()));
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) throws ParseException {
		EmployeeDTO employeeDTO = authService.signup(signupRequest);
		if (employeeDTO.getEmpEmail() == null || employeeDTO.getContactAdd() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					new ErrorResponse(HttpStatus.BAD_REQUEST.name(), new SysError("email-already-exists", new ErrorParam("email")))
					);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new SuccessReponse("success",employeeDTO , HttpStatus.OK.name()));
		}
	}

}
