package com.example.demo.service.user;

import java.util.List;

import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.User;

public interface IUserService {
	User save(User user);
	UserDTO findByUsername(String username);
	List<UserDTO> findAll();
}
