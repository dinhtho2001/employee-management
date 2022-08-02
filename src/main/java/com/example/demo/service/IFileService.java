package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
	ResponseEntity<?> uploadFile(MultipartFile file);
}
