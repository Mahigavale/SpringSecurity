package com.hotel.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class Securityconfig {
	
	
	@Autowired
	public UserDetailsService myuserdetailsservice;
	
	
	@Bean
	public SecurityFilterChain mysecurity(HttpSecurity http) throws Exception
	{
		http
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/Hotel/**").hasAuthority("ROLE_ADMIN")
		.anyRequest().permitAll()
		.and()
		.httpBasic();
		
		return http.build();
		
	}
	
	
	@Bean
	public AuthenticationProvider myauth()
	{
		
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
		
		provider.setUserDetailsService(myuserdetailsservice);
		
		return  provider;
	}

}
