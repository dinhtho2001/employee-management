package com.example.demo.service;

import com.example.demo.dto.SalaryBonusDTO;
import com.example.demo.dto.response.SalaryBonusResponse;

public interface ISalaryBonusService {
	SalaryBonusResponse findAll(int page, int limit);
	int totalTtem();
	SalaryBonusDTO findOne(Long id);
	SalaryBonusDTO create(SalaryBonusDTO dto);
	SalaryBonusDTO update(SalaryBonusDTO dto);
	String delete(Long id);
}
