package com.nagarro.restfulservice.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hrdata")
public class Hr {
	@Id
	private long id;
	private String  username;
	private String password;
	
	public Hr(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Hr() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Hr [id=" + id + ", username=" + username + ", password=" + password + "]";
	}	
}
