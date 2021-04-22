package com.hydroyura.TechDocsSymbiosis.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
		
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				
				.antMatchers("/opp/edit/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				
			.and()
			.formLogin();

	}
	
	
	
	@Bean
	public UserDetailsService users() {
		
		UserDetails admin = User.builder()
			.username("YuryKlimchuk")
			.password("{bcrypt}$2y$12$lvQqs8DtZkZ9ur4DOxWXTu6eAM08rDeQLLgm2vN7kgy5lxRukj6cK")
			.roles("ADMIN")
			.build();
		
		UserDetails smirnovNikita = User.builder()
				.username("NikitaSmirnov")
				.password("{bcrypt}$2y$12$lvQqs8DtZkZ9ur4DOxWXTu6eAM08rDeQLLgm2vN7kgy5lxRukj6cK")
				.roles("TEHNOLOG")
				.build();
			
		return new InMemoryUserDetailsManager(admin, smirnovNikita);
		
	}
}
