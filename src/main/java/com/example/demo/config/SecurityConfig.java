package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.demo.config.jwt.AuthenticationFilter;
import com.example.demo.config.jwt.AuthorizationFilter;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.user.impl.UserDetailsServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private  UserDetailsServiceImpl detailsServiceImpl;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(detailsServiceImpl)
			.passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.cors()
			.and().csrf().disable()
			.authorizeRequests()
			.antMatchers("/").permitAll()//.hasAnyAuthority("USER","ADMIN")
			.antMatchers("/employees/**").hasAuthority("USER")
			.antMatchers("/leaves/**").hasAuthority("ADMIN")
			.antMatchers("/users/**").permitAll()
			.anyRequest().authenticated()
			.and().httpBasic()
			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.clearAuthentication(true)
			.logoutSuccessUrl("/")
			.deleteCookies("JSESSIONID")
			.invalidateHttpSession(true).permitAll()                                 	                                                                          
			.and().exceptionHandling().accessDeniedPage("/403")
			.and()
			//.addFilter(new AuthenticationFilter(authenticationManager()))
			//.addFilter(new AuthorizationFilter(authenticationManager(), userRepository, detailsServiceImpl))
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
			;
		
	}
	@Bean
	  CorsConfigurationSource corsConfigurationSource() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
	    return source;
	  }
}
