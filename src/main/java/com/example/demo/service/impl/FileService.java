package com.example.demo.service.impl;

import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.controller.FileController;
import com.example.demo.dto.response.FileResponse;
import com.example.demo.dto.response.MessageResponse;
import com.example.demo.service.IFileService;

@Service
public class FileService implements IFileService {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Value("${file.upload-dir}")
	String fileDerectory;

	@Override
	public ResponseEntity<?> uploadFile(MultipartFile file) {
		try {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			if (fileName.contains("..")) {
				return ResponseEntity.ok("Sorry! Filename contains invalid path sequence " + fileName);
			}
			File myFile = new File(fileDerectory + file.getOriginalFilename());
			myFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(myFile);
			fos.write(file.getBytes());
			fos.close();

			return ResponseEntity.status(HttpStatus.OK).body(new FileResponse("access", fileName, file.getContentType(), file.getSize()));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.ok(new MessageResponse("fail"));
		}
	}

}
