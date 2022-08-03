package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.example.demo.config.jwt.JwtUtils;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO findByUsername(String username) {
//		List<UsersRoles> usersRoles = userRepository.findByUsername(username).getUsersRoleses();
//		if (usersRoles != null) {
//			System.out.print("User Name: " + username);
//			List<Role> roles = new ArrayList<>();
//			for (UsersRoles item : usersRoles) {
//				Role role = item.getRole();
//				roles.add(role);
//			}
//			if (roles != null) {
//				for (Role role : roles) {
//					System.out.print(" -- role: " + role.getName());
//				}
//			}
//			return null;
//		}
//		else {
//			return null;
//		}
		return null;
	}

	@Override
	public UserResponse findAll() {
		try {
			UserResponse response = new UserResponse();
			List<User> users = userRepository.findAll();
			List<UserDTO> dtos = new ArrayList<>();
			for (User user : users) {
				UserDTO dto = modelMapper.map(user, UserDTO.class);
				dtos.add(dto);
			}
			response.setMessage("cuccess");
			response.setStatus("200 ok");
			if(dtos!=null) {
				response.setData(dtos);
			}
			return response;
		} catch (Exception e) {
			UserResponse response = new UserResponse();
			response.setMessage("failure");
			return response;
		}
		
		
	}

	@Override
	public UserResponse findById(Long id) {
		try {
			UserResponse response = new UserResponse();
			User user = userRepository.findById(id).orElse(new User());
			List<UserDTO> dtos = new ArrayList<>();
			UserDTO dto = modelMapper.map(user, UserDTO.class);
			dtos.add(dto);
			response.setMessage("cuccess");
			response.setData(dtos);
			response.setStatus(null);
			return response;
		} catch (Exception e) {
			logger.error("error: {}",e.getMessage());
			UserResponse response = new UserResponse();
			response.setMessage("failure");
			response.setStatus(null);
			return response; 
		}
	}
	
	

}
