package com.example.demo.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.response.FileResponse;
import com.example.demo.service.IFileService;

@RestController
@RequestMapping("/api/file/")
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@Autowired
	IFileService fileService;

	@PostMapping("/uploadFile")
	public ResponseEntity<FileResponse> uploadFile(@RequestParam("File") MultipartFile multipartFile)
			throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		long size = multipartFile.getSize();
		String fileType = multipartFile.getContentType();
		fileService.saveFile(fileName,multipartFile);
		FileResponse response = new FileResponse("Access", fileName, fileType, size);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/downloadFile/{fileName}")
	public ResponseEntity<?> downloadFile(@PathVariable("fileName") String fileName) {
		Resource resource = null;
		try {
			resource = fileService.getFileAsResource(fileName);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	
		if (resource == null) {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }
		String contentType = "application/octet-stream";
		String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION,headerValue)
				.body(resource);
	}

}
