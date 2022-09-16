package com.example.demo.payload.response;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.QualificationDTO;

import lombok.Data;

@Data
public class QualificationResponse {

	private int page;
	private int totalPage;
	private List<QualificationDTO> listResult = new ArrayList<>();

}
