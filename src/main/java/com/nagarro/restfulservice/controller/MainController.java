package com.nagarro.restfulservice.controller;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.restfulservice.entities.Employee;
import com.nagarro.restfulservice.entities.Hr;
import com.nagarro.restfulservice.services.EmployeeService;
import com.nagarro.restfulservice.services.HrService;

@RestController
public class MainController {
	
	@Autowired
	private EmployeeService employeeService; 
	
	@Autowired
	private HrService hrService;
	
	@GetMapping("/login")
	public boolean home() {
		  return false;
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return this.employeeService.getEmployees();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable String employeeId) {
		return this.employeeService.getEmployee(Long.parseLong(employeeId)); 
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee emp) {
		return this.employeeService.addEmployee(emp);
	}
	
	@PutMapping("/employees")
	public Employee updateCourse(@RequestBody Employee emp) {
		return this.employeeService.updateEmployee(emp);
	}
	
	@PostMapping("/hrlogin")
	public boolean validate(@RequestBody Hr hr) {
		System.out.println(hr.getUsername() + " " + hr.getPassword());
		if(hrService.findByUsernameAndPassword(hr.getUsername(), hr.getPassword()) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	@GetMapping("/download")
	  public ResponseEntity<Resource> getFile() {
	    String filename = "employees.csv";
	    InputStreamResource file = new InputStreamResource(employeeService.downloadCsv());
	    
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/csv"))
	        .body(file);
	  }
}
