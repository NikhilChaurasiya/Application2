package com.nagarro.restfulservice.services;

import com.nagarro.restfulservice.entities.Hr;

public interface HrService {
	public  Hr findByUsernameAndPassword(String username, String password);
}
