package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Actor;
import com.example.Service.ActorService;

@RestController
@RequestMapping("/Actor")
public class ActorController {
	
	
	@Autowired
	private ActorService service;
	
	@PostMapping("/add-actor")
	public String add(@RequestBody Actor actor) throws Exception
	{
		
		return service.addservice(actor);
	}
	
	@GetMapping("/get-actor")
	public List<Actor> getall()
	{
		return service.getservice();
	}
	

}
