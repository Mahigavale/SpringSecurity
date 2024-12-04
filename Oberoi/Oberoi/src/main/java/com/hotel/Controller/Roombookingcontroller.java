package com.hotel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.Service.RoombookingService;

@RestController
public class Roombookingcontroller {
	
	
	@Autowired
	public RoombookingService service;

}
