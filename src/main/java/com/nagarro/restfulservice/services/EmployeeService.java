package com.nagarro.restfulservice.services;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.nagarro.restfulservice.entities.Employee;


public interface EmployeeService {
	public List<Employee> getEmployees();
	
	public Employee getEmployee(long employeeId);
	
	public Employee addEmployee(Employee employee);
	
	public Employee updateEmployee(Employee employee);
	
	public ByteArrayInputStream downloadCsv();
	
	
}
