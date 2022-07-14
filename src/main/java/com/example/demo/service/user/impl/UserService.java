package com.example.demo.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.user.UserDTO;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.UsersRoles;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Login fail !");
		}
		else {
			List<GrantedAuthority> grantedList = new ArrayList<GrantedAuthority>();
			GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
			grantedList.add(authority);
			UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					grantedList);
			// test
			System.out.print(user.getUsername() + " -- " + user.getPassword());

			return userDetails;
		}
	}

	//pase
	public List<GrantedAuthority> getGrantedList(String username) {
		List<UsersRoles> usersRoles = userRepository.findByUsername(username).getUsersRoleses();
		List<GrantedAuthority> grantedList = new ArrayList<>();
		if (usersRoles != null) {
			List<Role> roles = new ArrayList<>();
			for (UsersRoles item : usersRoles) {
				Role role = item.getRole();
				roles.add(role);
			}
			if (roles != null) {
				for (Role role : roles) {
					String roleStr = role.getName();
					GrantedAuthority authority = new SimpleGrantedAuthority(roleStr);
					grantedList.add(authority);
				}
			}
		}
		return grantedList;
	}

	// pause
	public List<UserDTO> findAll() {
		List<User> user = userRepository.findAll();

		return null;
	}

	public String save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "success " + user.getUsername() + "\\" + user.getPassword();
	}

}
