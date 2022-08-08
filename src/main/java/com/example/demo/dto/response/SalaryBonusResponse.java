package com.example.demo.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.SalaryBonusDTO;

import lombok.Data;

@Data
public class SalaryBonusResponse {
	private int page;
	private int totalPage;
	private List<SalaryBonusDTO> listResult = new ArrayList<>();
	
}
