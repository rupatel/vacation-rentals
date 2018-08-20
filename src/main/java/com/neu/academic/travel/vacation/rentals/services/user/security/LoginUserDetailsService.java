package com.neu.academic.travel.vacation.rentals.services.user.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.neu.academic.travel.vacation.rentals.models.user.LoginDetails;
import com.neu.academic.travel.vacation.rentals.repositories.user.LoginDetailsRepository;

@Component
public class LoginUserDetailsService implements UserDetailsService{
	private final LoginDetailsRepository repository;
	public LoginUserDetailsService(LoginDetailsRepository repository) {
		this.repository = repository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginDetails credentials = this.repository.findByUserName(username);
		return new User(credentials.getUserName(),credentials.getPassword(), 
				AuthorityUtils.createAuthorityList(credentials.getRoles()));
	}
}