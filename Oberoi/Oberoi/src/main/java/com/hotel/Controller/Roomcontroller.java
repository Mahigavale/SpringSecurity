package com.hotel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.Exceptions.HotelnotexistsException;
import com.hotel.Exceptions.SomethingwentwrongException;
import com.hotel.Service.Roomservice;
import com.hotel.entity.Room;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping("Hotel/Roomconfig")
@RestController
public class Roomcontroller {
	
	
	@Autowired
	public Roomservice service;
	
	
	
	@PostMapping("/add-room")
	public Room addroom(@RequestBody Room room) throws HotelnotexistsException, Exception
	{
		return  service.addroom(room);
	}
	
	@GetMapping("/get-room/{id}")
	public Room getbyidroom(@PathVariable("id") int id) throws SomethingwentwrongException
	{
		return service.getroom(id);
	}

}
