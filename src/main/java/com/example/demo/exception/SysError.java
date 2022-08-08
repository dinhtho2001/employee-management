package com.example.demo.exception;

import java.util.List;

import lombok.Data;

@Data
public class SysError {

	private String code;
	private List<ErrorParam> errorParams;

}
