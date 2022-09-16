package com.example.demo.service;

import com.example.demo.dto.JobDepartmentDTO;
import com.example.demo.payload.response.JobDepartmentResponse;

public interface IJobDepartmentService {

	JobDepartmentResponse findAll(int page, int limit);
	int totalTtem();
	JobDepartmentDTO findOne(Long id);
	JobDepartmentDTO create(JobDepartmentDTO employeeDTO);
	JobDepartmentDTO update(JobDepartmentDTO employeeDTO);
	String delete(Long id);
}
