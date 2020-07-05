package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		//	ROLE USER ADMIN
			.antMatchers("/").hasAnyAuthority("ADMIN","USER")
			.antMatchers("/update/profile/**").hasAnyAuthority("ADMIN","USER")
			
			// ROLE ADMIN
			.antMatchers("/Fonction/update/**").hasAnyAuthority("ADMIN")
			.antMatchers("/Fonction/delete/**").hasAnyAuthority("ADMIN")
			.antMatchers("/Categorie/add").hasAnyAuthority("ADMIN")
		.antMatchers("/Categorie/lister").hasAnyAuthority("ADMIN")
		
		
		.antMatchers("Categorie/update/**").hasAnyAuthority("ADMIN")
		.antMatchers("/Categorie/delete/**").hasAnyAuthority("ADMIN")
	.antMatchers("/Questions/choixReponse/**").hasAnyAuthority("ADMIN")
	.antMatchers("/Choixreponse/update/**").hasAnyAuthority("ADMIN")
	.antMatchers("/Choixreponse/delete/**").hasAnyAuthority("ADMIN")
	.antMatchers("/delete/**").hasAnyAuthority("ADMIN")
	.antMatchers("/Questionnaire").hasAnyAuthority("ADMIN")
	.antMatchers("/add").hasAnyAuthority("ADMIN")
	.antMatchers("/Questions/add").hasAnyAuthority("ADMIN")
	.antMatchers("/Questions/update/**").hasAnyAuthority("ADMIN")
	.antMatchers("/Questions/delete/**").hasAnyAuthority("ADMIN")
	.antMatchers("/Type/add").hasAnyAuthority("ADMIN")
	.antMatchers("Type/lister/").hasAnyAuthority("ADMIN")
	.antMatchers("/Type/update/**").hasAnyAuthority("ADMIN")
	.antMatchers("/Type/delete/**").hasAnyAuthority("ADMIN")
	.antMatchers("/User/add").hasAnyAuthority("ADMIN")
	.antMatchers("/User/lister").hasAnyAuthority("ADMIN")
	.antMatchers("/User/update/").hasAnyAuthority("ADMIN")
	.antMatchers("/User/delete/**").hasAnyAuthority("ADMIN")
	.antMatchers("/addUserQuestionnaire/**").hasAnyAuthority("ADMIN")
	.antMatchers("/ReponduUser/**").hasAnyAuthority("ADMIN")

	//user 
	.antMatchers("/UserQuestionnaire/**").hasAnyAuthority("USER")
	.antMatchers("/User/Questionnaire/**").hasAnyAuthority("USER")
	.antMatchers("/User/Questions/**").hasAnyAuthority("USER")


	
			.anyRequest().authenticated()
			.and()
			.formLogin().permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/403")
			;
	}
}
