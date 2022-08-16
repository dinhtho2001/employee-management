package com.example.demo.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.request.UpdateRoleRequest;
import com.example.demo.dto.response.EmployeeResponse;
import com.example.demo.model.Employee;
import com.example.demo.model.Role;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	@Value("${file.upload-dir}")
	private Resource resource;

	@Override
	public EmployeeResponse findAll(int page, int limit) {
		EmployeeResponse response = new EmployeeResponse();
		try {
			Pageable pageable = PageRequest.of(page - 1, limit);
			response.setListResult(findAll(pageable));
		} catch (Exception e) {
			return null;
		} finally {
			response.setPage(page);
			response.setTotalPage((int) Math.ceil((double) (totalTtem()) / limit));

		}
		return response;
	}

	@Override
	public EmployeeDTO findOne(Long id) {
		try {
			Employee employee = repository.findById(id).orElse(null);
			EmployeeDTO dto = new EmployeeDTO();
			dto = modelMapper.map(employee, EmployeeDTO.class);
			return dto;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int totalTtem() {
		try {
			return (int) repository.count();
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public EmployeeDTO[] creates(EmployeeDTO[] dtos) {
		try {
			int i = 0;
			EmployeeDTO[] employeeDTOs = new EmployeeDTO[dtos.length];
			for (EmployeeDTO item : dtos) {
				Employee employee = repository.save(modelMapper.map(item, Employee.class));
				employeeDTOs[i] = modelMapper.map(employee, EmployeeDTO.class);
				i++;
			}
			return employeeDTOs;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public EmployeeDTO create(EmployeeDTO employeeDTO) {
		Employee employee = modelMapper.map(employeeDTO, Employee.class);
		Employee result = repository.save(employee);
		return modelMapper.map(result, EmployeeDTO.class);
	}

	public List<EmployeeDTO> findAll(Pageable pageable) {
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		List<Employee> employees = repository.findAll(pageable).getContent();
		for (Employee item : employees) {
			EmployeeDTO dto = modelMapper.map(item, EmployeeDTO.class);
			employeeDTOs.add(dto);
		}
		return employeeDTOs;
	}

	@Override
	public EmployeeDTO update(EmployeeDTO employeeDTO) {
		try {
			Employee employee = repository.findById(employeeDTO.getEmpId()).orElse(null);
			Employee entitis = modelMapper.map(employee, Employee.class);
			entitis = repository.save(entitis);
			return modelMapper.map(entitis, EmployeeDTO.class);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean delete(Long id) {
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deletes(Long[] ids) {
		try {
			for (long item : ids) {
				repository.deleteById(item);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean saveEmployeesToExcel(String fileName) throws IOException {
		String str = resource.getURI().toString().substring(6, resource.getURI().toString().length());
		File file = new File(str + "/" + fileName);
		if (fileName.contains(".xlsx")) {
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheetAt(0);
			List<Employee> employees = readEmployeeToExcel(sheet);
			workbook.close();
			for (Employee employee : employees) {
				repository.save(employee);
			}
			return true;
		} else if (fileName.contains(".xls")) {
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new HSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheetAt(0);
			List<Employee> employees = readEmployeeToExcel(sheet);
			workbook.close();
			for (Employee employee : employees) {
				repository.save(employee);
			}
			return true;
		}
		return false;
	}
	
	public List<Employee> readEmployeeToExcel(Sheet sheet) {
		List<Employee> employees = new ArrayList<>();
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Employee employee = new Employee();
			Boolean gender = false;
			Row row = sheet.getRow(i);
			employee.setLname(row.getCell(1).getStringCellValue());
			employee.setFname(row.getCell(2).getStringCellValue());
			if (row.getCell(3).getBooleanCellValue()) {
				gender = true;
			}
			employee.setGender(gender);
			employee.setAge(row.getCell(4).getDateCellValue());
			employee.setContactAdd("0" + (int) (row.getCell(5).getNumericCellValue()));
			employee.setEmpEmail(row.getCell(6).getStringCellValue());
			employee.setEmpPass(row.getCell(7).getStringCellValue());
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public Boolean updateRole(UpdateRoleRequest request) {
		try {
			Employee employee = new Employee();
			employee = repository.findOneByEmpId(request.getId());
			if(employee == null) {
				return false;
			}else {
				Role role = new Role();
				role.setName(request.getRole());
				Set<Role> roles = new HashSet<>();
				roles.add(role);
				employee.setRoles(roles);
				
				Employee result = repository.save(employee);
				if(result == null) {
					return false;
				}else {
					return true;
				}				
			}
		} catch (Exception e) {
			return false;
		}
//		return false;
	}

}
