package com.neu.academic.travel.vacation.rentals.configs.security;

import static com.neu.academic.travel.vacation.rentals.configs.security.SecurityConstants.SIGN_UP_URL;
import static com.neu.academic.travel.vacation.rentals.configs.security.SecurityConstants.ADD_USER_SERVICE;
import static com.neu.academic.travel.vacation.rentals.configs.security.SecurityConstants.LOGIN_URL;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.neu.academic.travel.vacation.rentals.services.user.security.LoginUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private LoginUserDetailsService userDetailsService;
	private PasswordEncoder passwordEncoder;
	
	public SecurityConfiguration(PasswordEncoder passwordEncoder,LoginUserDetailsService userDetailsService) {
		this.passwordEncoder = passwordEncoder;
		this.userDetailsService = userDetailsService;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(this.userDetailsService)
				.passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests()
        .antMatchers(HttpMethod.POST, ADD_USER_SERVICE,"/login").permitAll()
        .antMatchers(HttpMethod.GET, LOGIN_URL,SIGN_UP_URL,
        		"/","/login","/built/**","/css/**", "/js/**", "/images/**")
        .permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilter(new JWTAuthenticationFilter(authenticationManager(),getApplicationContext()))
        .addFilter(new JWTAuthorizationFilter(authenticationManager()))
        // this disables session creation on Spring Security
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}