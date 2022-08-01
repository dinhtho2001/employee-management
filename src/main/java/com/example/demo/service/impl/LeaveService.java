package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.converter.LeaveConverter;
import com.example.demo.dto.LeaveDTO;
import com.example.demo.dto.response.LeaveResponse;
import com.example.demo.model.entities.Employee;
import com.example.demo.model.entities.Leave;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.LeaveRepository;
import com.example.demo.service.ILeaveService;

@Service
public class LeaveService implements ILeaveService{

	@Autowired
	private LeaveRepository  leaveRepository;

	@Autowired
	private EmployeeRepository  employeeRepository;
	
	@Autowired
	private LeaveConverter converter ;

	@Override
	public LeaveResponse findAll(int page, int limit) {
		LeaveResponse  leaveResponse= new LeaveResponse();
		leaveResponse.setPage(page);
		Pageable pageable = PageRequest.of(page-1, limit);
		leaveResponse.setListResult(findAll(pageable));
		leaveResponse.setTotalPage((int)Math.ceil( (double) (totalTtem()) / limit));
		return leaveResponse;
	}
	
	@Override
	public int totalTtem() {
		return (int)leaveRepository.count();
	}

	@Override
	public LeaveDTO findOne(Long id) {
		Leave leave = leaveRepository.findById(id).orElse(null);
		LeaveDTO dto = converter.toDTO(leave);
//		Employee employee = employeeRepository.findOneByEmpId(leave.getEmployeeId());
//		dto.setEmployeeId(employee.getEmpId());
		return dto;
	}
	
	@Override
	public LeaveDTO create(LeaveDTO dto) {
		Employee employee = employeeRepository.findOneByEmpId(dto.getEmployeeId());
		Leave leave = converter.toEntity(dto);
		leave.setEmployeeId(employee);
		Leave result = leaveRepository.save(leave);
		return converter.toDTO(result);
	}
	
	@Override
	public String delete(Long id) {
		leaveRepository.deleteById(id);
		return "Delete success";
	}
	
	public List<LeaveDTO> findAll(Pageable pageable){		
		List<LeaveDTO> leaveDTOs = new ArrayList<>();
		List<Leave> leaves = leaveRepository.findAll(pageable).getContent();
		//Employee employee = employeeRepository.findOneByEmpId(dto.getEmployeeId());
		for(Leave item : leaves) {
			//item.setEmployeeId(employee);
			LeaveDTO dto = converter.toDTO(item);
			leaveDTOs.add(dto);
		}
		return leaveDTOs;
	}

	@Override
	public LeaveDTO update(LeaveDTO dto) {
		Leave oldLeave = leaveRepository.findById(dto.getLeaveId()).orElse(null);
		Leave leave = converter.toEntity(dto, oldLeave);
		Employee employee = employeeRepository.findOneByEmpId(dto.getEmployeeId());
		leave.setEmployeeId(employee);
		leave = leaveRepository.save(leave);
		return converter.toDTO(leave);
	}
	
}
