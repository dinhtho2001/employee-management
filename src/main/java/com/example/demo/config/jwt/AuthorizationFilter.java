package com.example.demo.config.jwt;

import static com.example.demo.config.SecurityConstants.HEADER_STRING;
import static com.example.demo.config.SecurityConstants.SECRET;
import static com.example.demo.config.SecurityConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.user.impl.UserDetailsServiceImpl;

public class AuthorizationFilter extends BasicAuthenticationFilter {

	private UserRepository userRepository;

	private UserDetailsServiceImpl detailsServiceImpl;

	public AuthorizationFilter(AuthenticationManager authManager, UserRepository userRepository,
			UserDetailsServiceImpl detailsServiceImpl) {
		super(authManager);
		this.userRepository = userRepository;
		this.detailsServiceImpl = detailsServiceImpl;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader(HEADER_STRING);

		if (header == null || !header.startsWith(TOKEN_PREFIX)) {
			chain.doFilter(req, res);
			return;
		}

		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);

		if (token != null) {
			// parse the token.
			String userName = JWT.require(Algorithm.HMAC512(SECRET.getBytes())).build()
					.verify(token.replace(TOKEN_PREFIX, "")).getSubject();

			if (userName != null) {
				userRepository.findByUsername(userName);
				List<GrantedAuthority> grantedAuthorities = detailsServiceImpl.grantedAuthorities(userName);
				return new UsernamePasswordAuthenticationToken(userName, null, grantedAuthorities);
			}
			return null;
		}
		return null;
	}

}
