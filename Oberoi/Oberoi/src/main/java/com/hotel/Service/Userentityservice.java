package com.hotel.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotel.entity.Userentity;
import com.hotel.repository.Userrepo;

@Service
public class Userentityservice {
	
	@Autowired
	public Userrepo repo;
	
	
	BCryptPasswordEncoder encode=new BCryptPasswordEncoder(10);
	
	
	public String adduser(Userentity entity)
	{
		System.out.println("Password:"+entity.getPassword());
	
		entity.setPassword(encode.encode(entity.getPassword()));
		
		repo.save(entity);
		
		return "Success !";
	
	}

}
