package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
	ResponseEntity<?> uploadFile(MultipartFile file);
	ResponseEntity<?> loadFileAsResource(String fileName, HttpServletRequest request);
	Resource loadFileAsResource(String fileName);
}