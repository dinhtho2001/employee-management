package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.QualificationDTO;
import com.example.demo.dto.response.QualificationResponse;
import com.example.demo.model.Employee;
import com.example.demo.model.Qualification;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.QualificationRepository;
import com.example.demo.service.IQualificationService;

@Service
public class QualificationService implements IQualificationService{

	@Autowired
	private QualificationRepository  qualificationRepository;

	@Autowired
	private EmployeeRepository  employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public QualificationResponse findAll(int page, int limit) {
		QualificationResponse  response = new QualificationResponse();
		response.setPage(page);
		Pageable pageable = PageRequest.of(page-1, limit);
		response.setListResult(findAll(pageable));
		response.setTotalPage((int)Math.ceil( (double) (totalTtem()) / limit));
		return response;
	}
	
	@Override
	public int totalTtem() {
		return (int)qualificationRepository.count();
	}

	@Override
	public QualificationDTO findOne(Long id) {
		Qualification qualification = qualificationRepository.findById(id).orElse(null);		
		QualificationDTO dto = new QualificationDTO();
		dto = modelMapper.map(qualification, QualificationDTO.class);
		return dto;
	}

	@Override
	public QualificationDTO create(QualificationDTO dto) {
		Employee employee = employeeRepository.findOneByEmpId(dto.getEmp_id());
		Qualification qualification = modelMapper.map(dto, Qualification.class);
		qualification.setEmployeeId(employee);
		Qualification entitis = qualificationRepository.save(qualification);
		return modelMapper.map(entitis, QualificationDTO.class);
	}
	
	@Override
	public String delete(Long id) {
		qualificationRepository.deleteById(id);
		return "Delete success";
	}
	
	public List<QualificationDTO> findAll(Pageable pageable){		
		List<QualificationDTO> qualificationDTOs = new ArrayList<>();
		List<Qualification> qualifications = qualificationRepository.findAll(pageable).getContent();
		//Employee employee = employeeRepository.findOneByEmpId(dto.getEmployeeId());
		for(Qualification item : qualifications) {
			//item.setEmployeeId(employee);
			QualificationDTO dto = modelMapper.map(item, QualificationDTO.class);
			qualificationDTOs.add(dto);
		}
		return qualificationDTOs;
	}

	@Override
	public QualificationDTO update(QualificationDTO dto) {
		Qualification oldqualification = qualificationRepository.findById(dto.getQualId()).orElse(null);
		Qualification qualification = modelMapper.map(dto, Qualification.class);
		Employee employee = employeeRepository.findOneByEmpId(dto.getEmp_id());
		qualification.setEmployeeId(employee);
		qualification = qualificationRepository.save(qualification);
		return  modelMapper.map(qualification,QualificationDTO.class);
	}
	
}
