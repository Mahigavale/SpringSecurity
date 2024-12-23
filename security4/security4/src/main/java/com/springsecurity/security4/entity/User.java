package com.springsecurity.security4.entity;

import com.fasterxml.jackson.databind.util.AccessPattern;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	private String username;
	@Email(regexp="[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}")
	private String useremail;
	private String usermobile;
	
	
	@JoinColumn
	@OneToOne
	private Location userlocation;
	
	@JoinColumn
	@OneToOne
	private Orders userOrder;

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

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUsermobile() {
		return usermobile;
	}

	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}

	public Location getUserlocation() {
		return userlocation;
	}

	public void setUserlocation(Location userlocation) {
		this.userlocation = userlocation;
	}

	public Orders getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(Orders userOrder) {
		this.userOrder = userOrder;
	}
	
	

}
