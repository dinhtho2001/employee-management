package com.example.demo.service;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
	Boolean saveFile(String fileName,MultipartFile multipartFile)throws IOException;
	Resource getFileAsResource(String filename)throws IOException;
}