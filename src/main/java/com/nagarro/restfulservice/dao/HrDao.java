package com.nagarro.restfulservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.restfulservice.entities.Hr;

public interface HrDao extends JpaRepository<Hr, Long> {
	public  Hr findByUsernameAndPassword(String username, String password);
}
