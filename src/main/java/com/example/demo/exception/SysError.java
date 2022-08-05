package com.example.demo.exception;

import java.util.List;

public class SysError {

	private String code;
	private List<ErrorParam> errorParams;

	public SysError() {

	}

	public SysError(String code, List<ErrorParam> errorParams) {
		super();
		this.code = code;
		this.errorParams = errorParams;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<ErrorParam> getFields() {
		return errorParams;
	}

	public void setFields(List<ErrorParam> fields) {
		this.errorParams = fields;
	}

}
