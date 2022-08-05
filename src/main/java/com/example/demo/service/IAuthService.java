package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.request.SignupRequest;
import com.example.demo.dto.response.JwtResponse;

public interface IAuthService {
	JwtResponse signin(LoginRequest loginRequest);
	UserDTO signup(SignupRequest signupRequest);
}
