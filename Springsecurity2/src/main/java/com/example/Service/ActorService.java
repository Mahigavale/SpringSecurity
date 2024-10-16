package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Actor;
import com.example.Repository.Actorrepo;

@Service
public class ActorService {
	
	@Autowired
	private Actorrepo repo;
	
	public String addservice(Actor actor) throws Exception
	{
		if(actor ==null)
		{
			throw new Exception("user can not be null.");		}
		repo.save(actor);
		
		return "actor with name:"+actor.getName()+"added sucessfully !";
		
	}
	
	
	public List<Actor> getservice()
	{
		return repo.findAll();
	}


}
