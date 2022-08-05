package com.example.demo.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jni.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.controller.FileController;
import com.example.demo.dto.response.FileResponse;
import com.example.demo.dto.response.MessageResponse;
import com.example.demo.exception.FileStorageException;
import com.example.demo.exception.MyFileNotFoundException;
import com.example.demo.service.IFileService;

@Service
public class FileService implements IFileService {

	private Path foundFile;
	
	@Value("${file.upload-dir}")
	private Resource resource;
	
	@Override
	public void saveFile(String fileName, MultipartFile multipartFile) throws IOException {
		URI uri = resource.getURI();
		Path uploadPath = Paths.get(uri);
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new IOException("Could not save file: " + fileName, e);
		}
	}

	@Override
	public Resource getFileAsResource(String fileName) throws IOException {
		URI uri = resource.getURI();
		Path dirPath = Paths.get(uri);
		Files.list(dirPath).forEach(file -> {
			if (file.getFileName().toString().startsWith(fileName)) {
				foundFile = file;
				return;
			}
		});
		if (foundFile != null) {
			return new UrlResource(foundFile.toUri());
		}
		return null;
	}

}
