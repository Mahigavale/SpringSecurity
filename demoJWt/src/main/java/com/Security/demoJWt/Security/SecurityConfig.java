package com.Security.demoJWt.Security;

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
	
	
	//spring3 does not work with the antMatchers but with the requestMatchers.
	//latest update.
	/*
	 * 
	 * requestMatchers(HttpMethod.GET).permitAll();
	 * 
	 * 
	 */
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain MysecurityFilter(HttpSecurity http) throws Exception
	{
	
		http.
		    csrf().disable()
		    .authorizeRequests()
		    .requestMatchers(HttpMethod.GET).hasRole("USER")
		    .requestMatchers(HttpMethod.POST).hasRole("ADMIN")
		    .anyRequest().authenticated()
		    .and()
		    .httpBasic();
		
		return http.build();
	}
	
	
	@Bean
	public UserDetailsService users()
	{
		
	 UserDetails admin=User.builder().username("Admin")
			 .password("{noop}password")
			 .roles("ADMIN")
			 .build();
	 
	 
	 UserDetails user=User.builder()
			 .username("Userr")
			 .password("{noop}Userr")
			 .roles("USER")
			 .build();
			 
			return new InMemoryUserDetailsManager(admin,user); 
	}

}
