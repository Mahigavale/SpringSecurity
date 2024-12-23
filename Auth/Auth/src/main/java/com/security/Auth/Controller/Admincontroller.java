package com.security.Auth.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.Auth.Entity.Dairyadmin;
import com.security.Auth.Service.Adminservice;

@RestController
public class Admincontroller {

	
	@Autowired
	private Adminservice service;
	@PostMapping("/add-admin")
	public String addadmin(@RequestBody Dairyadmin admin)
	{
		return service.saveadmin(admin);
	}
	
	@GetMapping("/get-all")
	public List<Dairyadmin> getall()
	{
		return service.getalladmins();
	}
}
