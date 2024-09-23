package com.Security.Config;

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
public class Securityconfig {
	
	
	@Bean
	public SecurityFilterChain mysecurity(HttpSecurity http) throws Exception
	{
		http
		.csrf().disable()
		.authorizeRequests()
		.requestMatchers(HttpMethod.POST).hasRole("ADMIN")
		.requestMatchers(HttpMethod.GET).permitAll()
		.anyRequest().authenticated()
		.and()
		.httpBasic();
		
		return http.build();
	}

	
	@Bean
	public UserDetailsService myusers()
	{
		UserDetails user=User.builder()
				.username("Akki")
				.password("{noop}okkkk")
				.roles("USER")
				.build();
		
		UserDetails admin=User.builder()
				.username("Mahesh")
				.password("{noop}Mahii")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(admin,user);
	}
	
}
