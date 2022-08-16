package com.example.demo.service;

import java.text.ParseException;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.request.SignupRequest;
import com.example.demo.dto.response.JwtResponse;

public interface IAuthService {
	JwtResponse signin(LoginRequest loginRequest);
	EmployeeDTO signup(SignupRequest signupRequest)throws ParseException ;
}
