package com.example.demo.payload.response;

import lombok.Data;

@Data
public class FileResponse {

	private String message;
	private String fileName;
    private String fileType;
    private long size;
    
}
