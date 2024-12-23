package com.products.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.Entity.Bottles;
import com.products.Repository.Bottlerepo;

@Service
public class Bottlesservice {
	
	@Autowired
	private Bottlerepo repo;
	
	
	public Bottles addbottle(Bottles bottle)
	{
		
		
		 var b1= repo.save(bottle);
		 
		 repo.flush();
		 
		 System.out.println(b1.getPrice());
		 System.out.println(b1.getName());
		 return b1;
		
		
	}
	
	
	public List<Bottles> getallbottles()
	{
		return repo.findAll();
		
	}

}
