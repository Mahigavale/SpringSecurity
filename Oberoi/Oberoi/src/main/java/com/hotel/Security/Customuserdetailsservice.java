package com.hotel.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hotel.entity.Userentity;
import com.hotel.repository.Userrepo;


@Service
public class Customuserdetailsservice implements UserDetailsService {

	
	@Autowired
	public Userrepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Userentity userentity=repo.findbyusername(username);
		
		System.out.println("****************************************");
		
		System.out.println(userentity.getUsername());
		
		return new Userprincipal(userentity);
	}
	
	

}
