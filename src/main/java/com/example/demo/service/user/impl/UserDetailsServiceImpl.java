package com.example.demo.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.UsersRoles;
import com.example.demo.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		try {
			List<GrantedAuthority> grantedAuthorities = grantedAuthorities(username);
			UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					grantedAuthorities);
			return userDetails;
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}

	public List<GrantedAuthority> grantedAuthorities(String username) {
		try {
			List<UsersRoles> usersRoles = userRepository.findByUsername(username).getUsersRoleses();
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			if (usersRoles != null) {
				System.out.print("name: " + username);
				List<Role> roles = new ArrayList<>();
				for (UsersRoles item : usersRoles) {
					Role role = item.getRole();
					roles.add(role);
				}
				if (roles != null) {
					for (Role role : roles) {
						String roleName = role.getName();
						System.out.print(" -- role: " + role.getName());
						GrantedAuthority authority = new SimpleGrantedAuthority(roleName);
						grantedAuthorities.add(authority);
					}
				}
			}
			return grantedAuthorities;
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}
	
}
