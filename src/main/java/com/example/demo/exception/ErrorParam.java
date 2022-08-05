package com.example.demo.exception;

import java.util.List;

public class ErrorParam {

	private List<Field> fields;

	public ErrorParam() {
		
	}
	
	public ErrorParam(List<Field> fields) {
		super();
		this.fields = fields;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

}
