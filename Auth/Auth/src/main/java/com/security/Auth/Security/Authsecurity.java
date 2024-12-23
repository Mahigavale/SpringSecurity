package com.security.Auth.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class Authsecurity {
	
	
	@Autowired
	public UserDetailsService myuserdetailservice;
	
	
	@Bean
	public SecurityFilterChain mysecurity(HttpSecurity http) throws Exception
	{
		http
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers(HttpMethod.POST).permitAll()
		.requestMatchers(HttpMethod.GET).hasRole("ADMIN")
		.anyRequest().permitAll()
		.and()
		.httpBasic() ;
		
		return http.build();
	}
	
	
	@Bean
	public AuthenticationProvider myauth()
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		
		provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
		provider.setUserDetailsService(myuserdetailservice);
		
		return provider;
	}

}
