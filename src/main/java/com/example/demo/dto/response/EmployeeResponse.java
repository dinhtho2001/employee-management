package com.example.demo.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.EmployeeDTO;

import lombok.Data;

@Data
public class EmployeeResponse {
	private int page;
	private int totalPage;
	private List<EmployeeDTO> listResult = new ArrayList<>();
	
}
