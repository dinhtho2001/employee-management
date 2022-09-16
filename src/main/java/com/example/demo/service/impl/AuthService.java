package com.example.demo.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.jwt.JwtUtils;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Employee;
import com.example.demo.model.Role;
import com.example.demo.payload.request.LoginRequest;
import com.example.demo.payload.request.SignupRequest;
import com.example.demo.payload.response.JwtResponse;
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
	PasswordEncoder passwordEncoder;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public JwtResponse signin(LoginRequest request) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		JwtResponse response = new JwtResponse();;
		response.setId(Integer.parseInt(userDetails.getId().toString()));
		response.setEmail(userDetails.getUsername());
		response.setRoles(roles);
		response.setAccess_token(token);
		response.setToken_type("Bearer");
		return response;
	}

	@Override
	public EmployeeDTO signup(SignupRequest request) throws ParseException {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		if (userRepository.existsByEmpEmail(request.getEmail())) {
			return employeeDTO;
		}
		else {
			Employee user = new Employee();
			user.setFname(request.getFname());
			user.setLname(request.getLname());
			user.setEmpEmail(request.getEmail());
			user.setEmpPass(passwordEncoder.encode(request.getPassword()));
			user.setContactAdd(request.getPhone());
			if(request.getGender().equals("true")) {
				user.setGender(true);	
			}else {
				user.setGender(false);	
			}
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date = df.parse(request.getBirthday());
			user.setAge(date);
			Role roles = roleRepository.findByName(request.getRole()).get();
			if(roles != null) {
				user.setRoles(Collections.singleton(roles));
			}else {
				Role role = new Role();
				role.setName("ROLE_USER");
				user.setRoles(Collections.singleton(role));
			}
			userRepository.save(user);
			employeeDTO = modelMapper.map(user, EmployeeDTO.class);
		}
		return employeeDTO;
	}

}
