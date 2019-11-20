package com.thp.spring.projetfinal.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.thp.spring.projetfinal.repository.UtilisateurRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
	private UtilisateurRepository utilisateurRepository;

	public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UtilisateurRepository userRepository) {
		super(authenticationManager);
		this.utilisateurRepository = userRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		response.addHeader("Access-Control-Allow-Headers",
				" Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization");
		response.addHeader("Access-Control-Expose-Headers",
				"Access-Control-Allow-Origin, Access-Control-Allow-Credentials, Authorization");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");

		String jwt = request.getHeader(JwtProperties.HEADER_STRING);
		if (request.getMethod().equals("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_OK);
		}

		else {
			if (jwt == null || !jwt.startsWith(JwtProperties.TOKEN_PREFIX)) {
				filterChain.doFilter(request, response);
				return;
			}
			Claims claims = Jwts.parser().setSigningKey(JwtProperties.SECRET)
					.parseClaimsJws(jwt.replace(JwtProperties.TOKEN_PREFIX, "")).getBody();
			if (claims.getExpiration().after(new Date())) {

				String username = claims.getSubject();
				Collection<GrantedAuthority> authorities = new ArrayList<>();
				ArrayList<Map<String, String>> roles = (ArrayList<Map<String, String>>) claims.get("roles");
				roles.forEach(r -> {
					authorities.add(new SimpleGrantedAuthority(r.get("authority")));
				});
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
						username, null, authorities);
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				filterChain.doFilter(request, response);
			} else {
				throw new JwtException("token expired !");
			}
		}

	}

}
