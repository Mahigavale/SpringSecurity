package com.security.Auth.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.Auth.Entity.Dairyadmin;
import com.security.Auth.Repository.Adminrepo;

@Service
public class Adminservice {

	
	@Autowired
	private Adminrepo repo;
	
	BCryptPasswordEncoder encode=new BCryptPasswordEncoder(10);
	
	public String saveadmin(Dairyadmin admin)
	{
		
		admin.setPassword(encode.encode(admin.getPassword()));
		repo.save(admin);
		
		return "Sucess !";
	}
	
	public List<Dairyadmin> getalladmins()
	{
	
		return repo.findAll();
	}
}
