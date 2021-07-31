package com.nagarro.restfulservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.restfulservice.dao.HrDao;
import com.nagarro.restfulservice.entities.Hr;

@Service
public class HrServiceImpl implements HrService{
	@Autowired
	private HrDao hrDao;
	
	public HrServiceImpl() {}

	@Override
	public Hr findByUsernameAndPassword(String username, String password) {
		return this.hrDao.findByUsernameAndPassword(username, password);
	}
	
}
