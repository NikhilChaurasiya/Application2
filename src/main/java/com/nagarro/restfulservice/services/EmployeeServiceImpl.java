package com.nagarro.restfulservice.services;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.restfulservice.dao.EmployeeDao;
import com.nagarro.restfulservice.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		
	}
	
	@Override
	public List<Employee> getEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public Employee getEmployee(long employeeId) {
		return employeeDao.getById(employeeId);

	}

	@Override
	public Employee addEmployee(Employee emp) {
		employeeDao.save(emp);	
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		employeeDao.save(emp);
		return emp;
	}

	@Override
	public ByteArrayInputStream  downloadCsv() {
		List<Employee> empls = employeeDao.findAll();
		ByteArrayInputStream in = CSVDownloader.employeeToCSV(empls);
		return in;
	}
	
	
	
}
