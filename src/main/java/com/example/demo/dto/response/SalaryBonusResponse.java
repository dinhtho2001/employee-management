package com.example.demo.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.SalaryBonusDTO;

public class SalaryBonusResponse {
	private int page;
	private int totalPage;
	private List<SalaryBonusDTO> listResult = new ArrayList<>();
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<SalaryBonusDTO> getListResult() {
		return listResult;
	}
	public void setListResult(List<SalaryBonusDTO> listResult) {
		this.listResult = listResult;
	}
	
	
}
