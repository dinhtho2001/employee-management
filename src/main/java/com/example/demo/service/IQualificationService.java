package com.example.demo.service;

import com.example.demo.dto.QualificationDTO;
import com.example.demo.dto.response.QualificationResponse;

public interface IQualificationService {

	QualificationResponse findAll(int page, int limit);
	int totalTtem();
	QualificationDTO findOne(Long id);
	QualificationDTO create(QualificationDTO dto);
	QualificationDTO update(QualificationDTO dto);
	String delete(Long id);
}
