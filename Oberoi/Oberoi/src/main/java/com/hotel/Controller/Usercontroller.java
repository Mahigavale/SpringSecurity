package com.hotel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.Service.Userentityservice;
import com.hotel.entity.Userentity;



@RestController
public class Usercontroller {
	
	@Autowired
	public Userentityservice service;
	
	
	@PostMapping("/add-user")
	public String addusercontroller(@RequestBody Userentity entity)
	{
		return service.adduser(entity);
	}

}
