package com.example.ord.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User_Details")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userid;
	private String username;
	private String email;
	
	public UserDetails() {}
	
	public UserDetails(int userid, String username, String email) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
