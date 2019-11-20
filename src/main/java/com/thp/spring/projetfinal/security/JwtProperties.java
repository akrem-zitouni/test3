package com.thp.spring.projetfinal.security;

public class JwtProperties {
	private JwtProperties() {
	}

	public static final String SECRET = "vintud@talan.com";

	public static final long EXPIRATION_TIME = 7_200_000;// 2h

	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";

}
