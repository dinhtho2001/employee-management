package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.config.jwt.AuthEntryPointJwt;
import com.example.demo.config.jwt.AuthTokenFilter;
import com.example.demo.service.userdetail.UserDetailsServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private  UserDetailsServiceImpl detailsServiceImpl;
	
	@Autowired
	private  AuthEntryPointJwt unauthorizedHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(detailsServiceImpl)
			.passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.cors()
			.and()
				.csrf().disable()
				.exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
			.and()
				.authorizeRequests()
				.antMatchers("/").permitAll()//.hasAnyAuthority("USER","ADMIN")
				.antMatchers("/employees/**").hasAuthority("USER")
				.antMatchers("/leaves/**").hasAuthority("ADMIN")
				.antMatchers("/api/auth/**").permitAll()
				.anyRequest().authenticated()
//			.and().httpBasic()
//			.and()
//				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				.clearAuthentication(true)
//				.logoutSuccessUrl("/")
//				.deleteCookies("JSESSIONID")
//				.invalidateHttpSession(true).permitAll()                                 	                                                                          
			.and()
				.exceptionHandling().accessDeniedPage("/403")
			.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
			;
		
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
	AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	

}
