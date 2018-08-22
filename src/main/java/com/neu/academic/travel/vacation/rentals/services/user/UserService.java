package com.neu.academic.travel.vacation.rentals.services.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neu.academic.travel.vacation.rentals.models.user.LoginDetails;
import com.neu.academic.travel.vacation.rentals.models.user.User;
import com.neu.academic.travel.vacation.rentals.repositories.user.UserRepository;

@Service
@RestController
public class UserService {
	UserRepository repository;
	public final PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository repository,PasswordEncoder passwordEncoder) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		
	}
	@PostMapping("/api/user")
	public User createUser(@RequestBody User user) {
		LoginDetails credentials = user.getCredentials();
		credentials.setPassword(passwordEncoder.encode(credentials.getPassword()));
		return this.repository.save(user);
	}
}