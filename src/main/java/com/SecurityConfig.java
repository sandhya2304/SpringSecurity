package com;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("ram").password("ji").roles("ADMIN","PROF");
		auth.inMemoryAuthentication().withUser("sandhya").password("ji").roles("STUDENT");
		auth.inMemoryAuthentication().withUser("prof").password("ji").roles("PROF");
		//auth.inMemoryAuthentication().withUser("ram").password("ji").roles("ADMIN","PROF");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.
		 csrf().disable().
		  authorizeRequests()
		    .anyRequest()
		     .authenticated()
		 .and()
		        .formLogin()
		         .loginPage("/login")
		          .permitAll();
		
	}
	
	
	

}
