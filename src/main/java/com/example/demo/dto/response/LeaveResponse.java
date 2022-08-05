package com.example.demo.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.LeaveDTO;

public class LeaveResponse {
	private int page;
	private int totalPage;
	private List<LeaveDTO> listResult = new ArrayList<>();
	
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
	public List<LeaveDTO> getListResult() {
		return listResult;
	}
	public void setListResult(List<LeaveDTO> listResult) {
		this.listResult = listResult;
	}
	
}
