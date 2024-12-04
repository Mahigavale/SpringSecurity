package com.hotel.Security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hotel.entity.Userentity;

public class Userprincipal implements UserDetails {
	
	
	@Autowired
	public Userentity entity;
	
	public Userprincipal(Userentity entity)
	{
		this.entity=entity;
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return entity.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
	}

	@Override
	public String getPassword() {
	
		return entity.getPassword();
	}

	@Override
	public String getUsername() {
		
		return entity.getUsername();
	}

}
