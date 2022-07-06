package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.converter.JobDepartmentConverter;
import com.example.demo.dto.JobDepartmentDTO;
import com.example.demo.dto.response.JobDepartmentResponse;
import com.example.demo.entity.JobDepartment;
import com.example.demo.repository.JobDepartmentRepository;
import com.example.demo.service.IJobDepartmentService;

@Service
public class JobDepartmentService implements IJobDepartmentService{
	@Autowired
	private JobDepartmentRepository repository;

	@Autowired
	private JobDepartmentConverter converter ;
	
	@Override
	public JobDepartmentResponse findAll(int page, int limit) {
		JobDepartmentResponse response = new JobDepartmentResponse();
		response.setPage(page);
		Pageable pageable = PageRequest.of(page-1, limit);
		response.setListResult(findAll(pageable));
		response.setTotalPage((int)Math.ceil( (double) (totalTtem()) / limit));
		return response;
	}

	@Override
	public int totalTtem() {
		return (int)repository.count();
	}

	@Override
	public JobDepartmentDTO findOne(Long id) {
		JobDepartment department = repository.findById(id).orElse(null);		 
		return converter.toDTO(department);
	}

	@Override
	public JobDepartmentDTO create(JobDepartmentDTO employeeDTO) {
		JobDepartment jobDepartment = converter.toEntity(employeeDTO);
		JobDepartment result = repository.save(jobDepartment);
		return converter.toDTO(result);
	}

	@Override
	public JobDepartmentDTO update(JobDepartmentDTO employeeDTO) {
		JobDepartment jobDepartment = repository.findById(employeeDTO.getJobId()).orElse(null);
		JobDepartment entiti = converter.toEntity(employeeDTO, jobDepartment);
		entiti = repository.save(entiti);
		return converter.toDTO(entiti);
	}

	@Override
	public String delete(Long id) {
		repository.deleteById(id);
		return "Delete success";
	}
	
	public List<JobDepartmentDTO> findAll(Pageable pageable){		
		List<JobDepartmentDTO> departmentDTOs = new ArrayList<>();
		List<JobDepartment> jobDepartments = repository.findAll(pageable).getContent();
		for(JobDepartment item : jobDepartments) {
			JobDepartmentDTO dto = converter.toDTO(item);
			departmentDTOs.add(dto);
		}
		return departmentDTOs;
	}

}
