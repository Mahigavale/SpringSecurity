package com.springsecurity.security4.Securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	@Bean
	public SecurityFilterChain mysec(HttpSecurity http)throws Exception
	{
		
		http.
		csrf().disable()
		.authorizeRequests()
		.requestMatchers(HttpMethod.POST).permitAll()
		.requestMatchers(HttpMethod.GET).hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.httpBasic();
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService users()
	{
		UserDetails ADMIN=User.builder().username("Mahesh").password("{noop}oyy").roles("ADMIN").build();
			
		
		return new InMemoryUserDetailsManager(ADMIN);
		
	}
	
}
