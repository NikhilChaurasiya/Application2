package com.nagarro.restfulservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.restfulservice.entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
