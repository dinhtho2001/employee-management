package com.example.demo.service;

import com.example.demo.dto.LeaveDTO;
import com.example.demo.payload.response.LeaveResponse;

public interface ILeaveService {

	LeaveResponse findAll(int page, int limit);
	int totalTtem();
	LeaveDTO findOne(Long id);
	LeaveDTO create(LeaveDTO dto);
	LeaveDTO update(LeaveDTO dto);
	String delete(Long id);
}
