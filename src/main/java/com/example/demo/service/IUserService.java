package com.example.demo.service;

import com.example.demo.dto.response.UserResponse;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.User;

public interface IUserService {
	User save(User user);
	UserDTO findByUsername(String username);
	UserResponse findAll();
	
	UserResponse findById(Long id);
}
