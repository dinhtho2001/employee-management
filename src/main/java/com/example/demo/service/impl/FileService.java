package com.example.demo.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.IFileService;

@Service
public class FileService implements IFileService {

	private Path foundFile;

	@Value("${file.upload-dir}")
	private Resource resource;

	@Override
	public Boolean saveFile(String fileName, MultipartFile multipartFile) throws IOException {
		try {
			URI uri = resource.getURI();
			Path uploadPath = Paths.get(uri);
			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			try (InputStream inputStream = multipartFile.getInputStream()) {
				Path filePath = uploadPath.resolve(fileName);
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
				return true;
			}catch (IOException e) {
				throw new IOException("Could not save file: " + fileName, e);
			}
		} catch (Exception e) {
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
