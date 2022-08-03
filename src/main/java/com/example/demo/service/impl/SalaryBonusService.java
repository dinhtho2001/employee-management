package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.converter.SalaryBonusConverter;
import com.example.demo.dto.SalaryBonusDTO;
import com.example.demo.dto.response.SalaryBonusResponse;
import com.example.demo.model.JobDepartment;
import com.example.demo.model.SalaryBonus;
import com.example.demo.repository.JobDepartmentRepository;
import com.example.demo.repository.SalaryBonusRepository;
import com.example.demo.service.ISalaryBonusService;

@Service
public class SalaryBonusService implements ISalaryBonusService{

	@Autowired
	private SalaryBonusRepository  salaryBonusRepository;

	@Autowired
	private JobDepartmentRepository  jobDepartmentRepository;
	
	@Autowired
	private SalaryBonusConverter converter ;
	
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
		SalaryBonus salaryBonus = salaryBonusRepository.findById(id).orElse(null);		
		return converter.toDTO(salaryBonus);
	}

	@Override
	public SalaryBonusDTO create(SalaryBonusDTO dto) {
		JobDepartment jobDepartment = jobDepartmentRepository.findOneByJobId(dto.getJob_id());
		SalaryBonus salaryBonus = converter.toEntity(dto);
		salaryBonus.setJobDepartmentId(jobDepartment);
		SalaryBonus entiti = salaryBonusRepository.save(salaryBonus);
		return converter.toDTO(entiti);
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
		List<SalaryBonusDTO> salaryBonusDTOs = new ArrayList<>();
		List<SalaryBonus> salaryBonus = salaryBonusRepository.findAll(pageable).getContent();
		for(SalaryBonus item : salaryBonus) {
			SalaryBonusDTO dto = converter.toDTO(item);
			salaryBonusDTOs.add(dto);
		}
		return salaryBonusDTOs;
	}

}
