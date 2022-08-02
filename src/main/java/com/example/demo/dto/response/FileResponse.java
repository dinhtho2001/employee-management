package com.example.demo.dto.response;

public class FileResponse {

	private String message;
	private String fileName;
    private String fileType;
    private long size;
    
	public FileResponse(String message, String fileName, String fileType, long size) {
		super();
		this.message = message;
		this.fileName = fileName;
		this.fileType = fileType;
		this.size = size;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
    
}
