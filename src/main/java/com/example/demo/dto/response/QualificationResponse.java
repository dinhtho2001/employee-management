package com.example.demo.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.QualificationDTO;

public class QualificationResponse {

	private int page;
	private int totalPage;
	private List<QualificationDTO> listResult = new ArrayList<>();
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
	public List<QualificationDTO> getListResult() {
		return listResult;
	}
	public void setListResult(List<QualificationDTO> listResult) {
		this.listResult = listResult;
	}
}
