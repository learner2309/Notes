package com.example.fitTrace.securitypack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
@Configuration
@EnableWebSecurity
public class CustomSecurityConfig {

	
	  @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
	  throws Exception { http .csrf(customizer->customizer.disable()) // Disable CSRF for simplicity
	  
	  
	  .authorizeHttpRequests(a->a.anyRequest().authenticated())
	  
	  .httpBasic(Customizer.withDefaults())
	  .sessionManagement(c->c.sessionCreationPolicy(SessionCreationPolicy.STATELESS
	  )) ;
	  
	  
	  
	  return http.build(); }
	 
}


