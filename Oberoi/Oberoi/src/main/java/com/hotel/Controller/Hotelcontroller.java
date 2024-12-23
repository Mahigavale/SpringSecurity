package com.hotel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.Exceptions.Hotelalreadyexists;
import com.hotel.Service.Hotelservice;
import com.hotel.entity.Hotelentity;

@RequestMapping("/Hotel")
@RestController
public class Hotelcontroller {
	
	
	@Autowired
	private Hotelservice service;
	
	@PostMapping("/add-hotel")
	public Hotelentity addhotelcontroller(@RequestBody Hotelentity entity) throws Hotelalreadyexists
	{
		return service.addhotel(entity);
		
	}

}
