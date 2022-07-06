package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.dto.SalaryBonusDTO;
import com.example.demo.entity.SalaryBonus;

@Component
public class SalaryBonusConverter {
	public SalaryBonus toEntity(SalaryBonusDTO dto) {
		SalaryBonus entity = new SalaryBonus();
		entity.setAmount(dto.getAmount());
		entity.setAnual(dto.getAnual());
		entity.setBonus(dto.getBonus());
		return entity;
	}
	
	public SalaryBonus toEntity(SalaryBonusDTO dto, SalaryBonus entity) {
		entity.setAmount(dto.getAmount());
		entity.setAnual(dto.getAnual());
		entity.setBonus(dto.getBonus());
		return entity;
	}
	
	public SalaryBonusDTO toDTO(SalaryBonus entity) {
		SalaryBonusDTO dto = new SalaryBonusDTO();
		dto.setSalaryId(entity.getSalaryId());
		dto.setAmount(entity.getAmount());
		dto.setAnual(entity.getAnual());
		dto.setBonus(entity.getBonus());
		return dto;
	}
}
