package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SalaryBonusDTO;
import com.example.demo.dto.response.SalaryBonusResponse;
import com.example.demo.model.JobDepartment;
import com.example.demo.model.Salary;
import com.example.demo.repository.JobDepartmentRepository;
import com.example.demo.repository.SalaryBonusRepository;
import com.example.demo.service.ISalaryBonusService;

@Service
public class SalaryBonusService implements ISalaryBonusService{

	@Autowired
	private SalaryBonusRepository  salaryBonusRepository;

	@Autowired
	private JobDepartmentRepository  jobDepartmentRepository;
	
	@Override
	public SalaryBonusResponse findAll(int page, int limit) {
		SalaryBonusResponse response = new SalaryBonusResponse();
		response.setPage(page);
		Pageable pageable = PageRequest.of(page-1, limit);
		response.setListResult(findAll(pageable));
		response.setTotalPage((int)Math.ceil( (double) (totalTtem()) / limit));
		return response;
	}

	@Override
	public int totalTtem() {
		return (int)salaryBonusRepository.count();
	}

	@Override
	public SalaryBonusDTO findOne(Long id) {
		Salary salary = salaryBonusRepository.findById(id).orElse(new Salary());		
		//return converter.toDTO(salary);
		return null;
	}

	@Override
	public SalaryBonusDTO create(SalaryBonusDTO dto) {
		JobDepartment jobDepartment = jobDepartmentRepository.findOneByJobId(dto.getJob_id());
		//Salary salaryBonus = converter.toEntity(dto);
		///salaryBonus.setJobDepartmentId(jobDepartment);
		//Salary entiti = salaryBonusRepository.save(salaryBonus);
		//return converter.toDTO(entiti);
		return null;
	}

	@Override
	public SalaryBonusDTO update(SalaryBonusDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Long id) {
		salaryBonusRepository.deleteById(id);
		return "Delete success";
	}
	
	public List<SalaryBonusDTO> findAll(Pageable pageable){		
		List<SalaryBonusDTO> salaryDTOs = new ArrayList<>();
		List<Salary> salary = salaryBonusRepository.findAll(pageable).getContent();
		for(Salary item : salary) {
			//SalaryBonusDTO dto = converter.toDTO(item);
			//salaryDTOs.add(dto);
		}
		return salaryDTOs;
	}

}
