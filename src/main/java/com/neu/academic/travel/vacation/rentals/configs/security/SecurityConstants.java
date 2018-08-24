package com.neu.academic.travel.vacation.rentals.configs.security;

public class SecurityConstants {
	public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String AUTHORIZATION_HEADER_STRING = "Authorization";
    public static final String TOKEN_EXPIRATION_HEADER_STRING = "TokenExpiry";
    public static final String LOGIN_URL = "/login";
    public static final String ADD_USER_SERVICE = "/api/user";
}
