package com.security.Auth.Security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.server.ResponseStatusException;

import com.security.Auth.Entity.Dairyadmin;

public class Adminprincipal  implements UserDetails{
	
	
	private Dairyadmin admin;
	
	public Adminprincipal(Dairyadmin admin)
	{
		this.admin=admin;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()  {
		
		if(!admin.getRoles().contains("ROLE_ADMIN"))
		{
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,"you are not authorized to access this part");
		}
		
		return admin.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return admin.getPassword();
	}

	@Override
	public String getUsername() {
		return admin.getName();
	}

}
