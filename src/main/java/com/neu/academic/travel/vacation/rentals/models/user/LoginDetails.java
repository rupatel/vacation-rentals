package com.neu.academic.travel.vacation.rentals.models.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class LoginDetails {
	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
	private String[] roles;
	
	@Id
	private String userName;
	
	private String password;
	
	@JsonIgnore
	@OneToOne
	private User user;
	
	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = PASSWORD_ENCODER.encode(password);
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
