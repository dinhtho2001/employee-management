package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.dto.QualificationDTO;
import com.example.demo.model.Qualification;

@Component
public class QualificationConverter {
	public Qualification toEntity(QualificationDTO dto) {
		Qualification entity = new Qualification();
		entity.setPosition(dto.getPosition());
		entity.setRequirements(dto.getRequirements());
		entity.setDateIn(dto.getDateIn());
		return entity;
	}
	
	public Qualification toEntity(QualificationDTO dto, Qualification entity) {
		entity.setPosition(dto.getPosition());
		entity.setRequirements(dto.getRequirements());
		entity.setDateIn(dto.getDateIn());
		return entity;
	}
	
	public QualificationDTO toDTO(Qualification entity) {
		QualificationDTO dto = new QualificationDTO();
		dto.setQualId(entity.getQualId());
		dto.setPosition(entity.getPosition());
		dto.setRequirements(entity.getRequirements());
		dto.setDateIn(entity.getDateIn());
		return dto;
	}
}
