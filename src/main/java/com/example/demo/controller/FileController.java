package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.IFileService;

@RestController
@RequestMapping("/api/file/")
public class FileController {

	@Autowired
	IFileService fileService;

	@PostMapping("/uploadFile")
	public ResponseEntity<?> uploadFile(@RequestParam("File") MultipartFile file) throws IOException {
		
		return ResponseEntity.ok(fileService.uploadFile(file));
	}

}
