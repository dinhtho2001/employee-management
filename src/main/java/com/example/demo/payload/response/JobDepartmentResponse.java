package com.example.demo.payload.response;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.JobDepartmentDTO;

import lombok.Data;

@Data
public class JobDepartmentResponse {
	private int page;
	private int totalPage;
	private List<JobDepartmentDTO> listResult = new ArrayList<>();
	
}
