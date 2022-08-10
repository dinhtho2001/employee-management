package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.response.EmployeeResponse;
import com.example.demo.model.Employee;
import com.example.demo.service.IEmployeeService;
import com.example.demo.service.IFileService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	@Autowired
	private IFileService fileService;

	@Value("${file.upload-dir}")
	private Resource resource;

	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public EmployeeResponse findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		return service.findAll(page, limit);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public EmployeeDTO findById(@PathVariable("id") Long id) {
		return service.findOne(id);
	}

	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public EmployeeDTO create(@RequestBody EmployeeDTO dto) {
		return service.create(dto);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public EmployeeDTO update(@RequestBody EmployeeDTO dto, @PathVariable("id") Long id) {
		dto.setEmpId(id);
		return service.update(dto);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String delete(@PathVariable("id") Long id) {
		return service.delete(id);
	}

	@DeleteMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String deletes(@RequestBody Long[] ids) {
		return service.deletes(ids);
	}

	@PostMapping("/readexcel")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> saveEmployees(@RequestParam("file") MultipartFile multipartFile)
			throws IOException, EncryptedDocumentException, InvalidFormatException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		if (fileService.saveFile(fileName, multipartFile)) {
			if (service.saveEmployeesToExcel(fileName)) {
				return ResponseEntity.status(HttpStatus.OK).body("Success");
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("false");
	}
}
