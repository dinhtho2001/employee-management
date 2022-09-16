package com.example.demo.service;

import java.text.ParseException;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.payload.request.LoginRequest;
import com.example.demo.payload.request.SignupRequest;
import com.example.demo.payload.response.JwtResponse;

public interface IAuthService {
	JwtResponse signin(LoginRequest loginRequest);
	EmployeeDTO signup(SignupRequest signupRequest)throws ParseException ;
}
