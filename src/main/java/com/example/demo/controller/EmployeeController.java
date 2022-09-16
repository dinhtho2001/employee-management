package com.example.demo.controller;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.exception.ErrorParam;
import com.example.demo.exception.SysError;
import com.example.demo.payload.request.UpdateRoleRequest;
import com.example.demo.payload.response.EmployeeResponse;
import com.example.demo.payload.response.ErrorResponse;
import com.example.demo.payload.response.SuccessReponse;
import com.example.demo.service.IEmployeeService;
import com.example.demo.service.IFileService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	@Autowired
	private IFileService fileService;

	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		EmployeeResponse employeeResponse = service.findAll(page, limit);
		if (employeeResponse.getPage() > employeeResponse.getTotal_page()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					new ErrorResponse(HttpStatus.BAD_REQUEST.name(), new SysError("page-error", new ErrorParam("page")))
					);
		}
		return ResponseEntity.ok(new SuccessReponse("success", employeeResponse, HttpStatus.OK.name()));
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(new SuccessReponse("success", service.findOne(id), HttpStatus.OK.name()));
	}
	
	@PutMapping("/update-role")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> updateRole(@RequestBody UpdateRoleRequest request) {
		if (service.updateRole(request)) {
			return ResponseEntity.ok("Success");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				new ErrorResponse(HttpStatus.BAD_REQUEST.name(), new SysError("email-not-found", new ErrorParam()))
				);
	}

	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO dto) {
		return ResponseEntity.ok(new SuccessReponse("success", service.create(dto), HttpStatus.OK.name()));
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> updateById(@RequestBody EmployeeDTO dto, @PathVariable("id") Long id) {
		dto.setEmpId(id);
		return ResponseEntity.ok(new SuccessReponse("success", service.update(dto), HttpStatus.OK.name()));
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		if(service.delete(id)) {
			return ResponseEntity.ok("Success");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				new ErrorResponse(HttpStatus.BAD_REQUEST.name(), new SysError("email-not-found", new ErrorParam()))
				);
		
	}

	@DeleteMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> deletesById(@RequestBody Long[] ids) {
		if(service.deletes(ids)) {
			return ResponseEntity.ok("Success");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				new ErrorResponse(HttpStatus.BAD_REQUEST.name(), new SysError("email-not-found", new ErrorParam()))
				);
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
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				new ErrorResponse(HttpStatus.BAD_REQUEST.name(), new SysError("email-not-found", new ErrorParam()))
				);
	}
}
