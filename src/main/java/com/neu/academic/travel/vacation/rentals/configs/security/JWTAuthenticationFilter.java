package com.neu.academic.travel.vacation.rentals.configs.security;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.neu.academic.travel.vacation.rentals.configs.security.SecurityConstants.EXPIRATION_TIME;
import static com.neu.academic.travel.vacation.rentals.configs.security.SecurityConstants.AUTHORIZATION_HEADER_STRING;
import static com.neu.academic.travel.vacation.rentals.configs.security.SecurityConstants.TOKEN_EXPIRATION_HEADER_STRING;
import static com.neu.academic.travel.vacation.rentals.configs.security.SecurityConstants.SECRET;
import static com.neu.academic.travel.vacation.rentals.configs.security.SecurityConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.academic.travel.vacation.rentals.models.user.LoginDetails;
import com.neu.academic.travel.vacation.rentals.repositories.user.LoginDetailsRepository;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    @Autowired
    private LoginDetailsRepository credRepo;
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager,ApplicationContext ctx) {
        this.authenticationManager = authenticationManager;
        credRepo = ctx.getBean(LoginDetailsRepository.class);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            LoginDetails creds = new ObjectMapper()
                    .readValue(req.getInputStream(), LoginDetails.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            AuthorityUtils.createAuthorityList(creds.getRoles()))
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String token = JWT.create()
                .withSubject(((User) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));
        res.addHeader(AUTHORIZATION_HEADER_STRING, TOKEN_PREFIX + token);
        res.addHeader(TOKEN_EXPIRATION_HEADER_STRING, TOKEN_PREFIX + token);
        ObjectMapper mapper = new ObjectMapper();
        com.neu.academic.travel.vacation.rentals.models.user.User user = 
        		credRepo.findByUsername(((User) auth.getPrincipal()).getUsername()).getUser();
        res.getOutputStream().write(mapper.writeValueAsBytes(user));
    }
}