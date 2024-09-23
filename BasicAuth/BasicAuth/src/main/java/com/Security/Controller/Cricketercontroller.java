package com.Security.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Security.Entity.Cricketer;
import com.Security.Repos.Cricketerrepo;

@RestController
@RequestMapping("/Cricketer")
public class Cricketercontroller {
	
	
	@Autowired
	private Cricketerrepo repo;
	
	
	@PostMapping("/add")
	public String add(@RequestBody Cricketer crc) throws Exception
	{
		
		if(crc !=null)
		{		repo.save(crc);
		
		return "Done";
		}
		else
		{
			throw new Exception("Error");
		}
		
	}
	
	@GetMapping("/get")
	public List<Cricketer> get()
	{
		return repo.findAll();
		
	}

}

