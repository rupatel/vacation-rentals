package com.neu.academic.travel.vacation.rentals.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neu.academic.travel.vacation.rentals.models.user.User;
import com.neu.academic.travel.vacation.rentals.repositories.user.UserRepository;

@Service
@RestController
public class UserService {
	@Autowired
	UserRepository repository;
	@PostMapping("/api/user")
	public User createUser(@RequestBody User user) {
		return this.repository.save(user);
	}
}