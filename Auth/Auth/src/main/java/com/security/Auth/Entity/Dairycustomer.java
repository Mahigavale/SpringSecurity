package com.security.Auth.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Dairycustomer {
	
	@Column(nullable=false)
	private String name;
	
	@Id
	private String contact;
	
	
	private String mail;
	
	

}
