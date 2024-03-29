package com.example.demo.controller;

import java.io.IOException;

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

import com.example.demo.payload.response.FileResponse;
import com.example.demo.service.IFileService;

@RestController
@RequestMapping("/api/file/")
public class FileController {

	@Autowired
	IFileService fileService;

	@PostMapping("/uploadFile")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile multipartFile)
			throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		if(fileService.saveFile(fileName,multipartFile)) {
			FileResponse response = new FileResponse();
			response.setMessage("Access");
			response.setFileName(fileName);
			response.setFileType(multipartFile.getContentType());
			response.setSize(multipartFile.getSize());
			return ResponseEntity.ok(response);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

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
