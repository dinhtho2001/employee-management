package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.dto.LeaveDTO;
import com.example.demo.model.Leave;

@Component
public class LeaveConverter {

	public Leave toEntity(LeaveDTO dto) {
		Leave entity = new Leave();
		entity.setDate(dto.getDate());
		entity.setReason(dto.getReason());
		return entity;
	}
	
	public Leave toEntity(LeaveDTO dto, Leave entity) {
		entity.setDate(dto.getDate());
		entity.setReason(dto.getReason());
		return entity;
	}
	
	public LeaveDTO toDTO(Leave entity) {
		LeaveDTO dto = new LeaveDTO();
		dto.setLeaveId(entity.getLeaveId());
		dto.setDate(entity.getDate());
		dto.setReason(entity.getReason());
		return dto;
	}
}
