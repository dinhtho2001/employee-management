package com.example.demo.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.LeaveDTO;

import lombok.Data;

@Data
public class LeaveResponse {
	private int page;
	private int totalPage;
	private List<LeaveDTO> listResult = new ArrayList<>();
	
	
}
