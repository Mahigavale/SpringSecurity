package com.example.Security;

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

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	
	@Bean
	public SecurityFilterChain mysecurity(HttpSecurity http) throws Exception
	{
		http
		 .csrf().disable()
		 .authorizeRequests()
		 .requestMatchers(HttpMethod.POST).hasRole("ADMIN")
		 .requestMatchers(HttpMethod.GET).hasAnyRole("ADMIN","USER")
		 .requestMatchers(HttpMethod.PUT).permitAll()
		 .requestMatchers(HttpMethod.DELETE).permitAll()
		 .anyRequest().authenticated()
		 .and()
		 .httpBasic();
		
		return http.build();
		 
	}
	
	@Bean
	public UserDetailsService users()
	{
		UserDetails admin=User.builder()
				.username("Mahesh")
				.password("{noop}Mahesh")
				.roles("ADMIN","USER")
				.build();
		
		UserDetails user=User.builder()
				.username("Akshay")
				.password("{noop}Akki")
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(admin,user);
	}

}


/*

UserDetailsService-> UserDetails->InMemoryUserDetailsManager->User
*/