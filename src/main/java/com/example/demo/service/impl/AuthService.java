package com.example.demo.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.jwt.JwtUtils;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.request.SignupRequest;
import com.example.demo.dto.response.JwtResponse;
import com.example.demo.dto.response.MessageResponse;
import com.example.demo.model.Employee;
import com.example.demo.model.Role;
import com.example.demo.model.enums.ERoles;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.IAuthService;
import com.example.demo.service.userdetail.UserDetailsImpl;

@Service
public class AuthService implements IAuthService {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	EmployeeRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public JwtResponse signin(LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		JwtResponse response = new JwtResponse();
		response.setToken(token);
		response.setId(userDetails.getId().toString());
		response.setUsername(userDetails.getUsername());
		response.setRoles(roles);
		return response;
	}

	@Override
	public EmployeeDTO signup(SignupRequest signupRequest) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		if (userRepository.existsByEmpEmail(signupRequest.getUsername())) {
			return employeeDTO;
		}
		else {
			Employee user = new Employee();
			user.setEmpEmail(null);
			user.setEmpPass(null);
			user.setContactAdd(null);
			Set<String> strRoles = signupRequest.getRole();
			Set<Role> roles = new HashSet<>();
			if (strRoles == null) {
				Role userRole = roleRepository.findByName(ERoles.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(userRole);
			} else {
				strRoles.forEach(role -> {
					switch (role) {
					case "admin":
						Role adminRole = roleRepository.findByName(ERoles.ROLE_ADMIN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(adminRole);
						break;
					default:
						Role userRole = roleRepository.findByName(ERoles.ROLE_USER)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(userRole);
					}
				});
			}
			user.setRoles(roles);
			userRepository.save(user);
			employeeDTO = modelMapper.map(user, EmployeeDTO.class);
		}
		return employeeDTO;
	}

}
