package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

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
	public List<UserDTO> findAll() {
		List<User> users = userRepository.findAll();
		List<UserDTO> dtos = new ArrayList<>();
		for (User user : users) {
			UserDTO dto = modelMapper.map(user, UserDTO.class);
			dtos.add(dto);
		}
		return dtos;
	}
	
	

}
