package com.example.demo.service.userdetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private EmployeeRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee user = userRepository.findByEmpEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		return UserDetailsImpl.build(user);
	}
	
}
