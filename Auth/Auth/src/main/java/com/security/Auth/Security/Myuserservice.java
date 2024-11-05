package com.security.Auth.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.Auth.Entity.Dairyadmin;
import com.security.Auth.Repository.Adminrepo;

@Service
public class Myuserservice implements UserDetailsService {
	
	@Autowired
	public Adminrepo repo;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Dairyadmin admin=repo.findbyemail(username);
		return new Adminprincipal(admin);
	}

}
