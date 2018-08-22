package com.neu.academic.travel.vacation.rentals.repositories.user;

import org.springframework.data.repository.Repository;

import com.neu.academic.travel.vacation.rentals.models.user.LoginDetails;

@org.springframework.stereotype.Repository
public interface LoginDetailsRepository extends Repository<LoginDetails,Long> {
	LoginDetails save(LoginDetails credentials);
	LoginDetails findByUserName(String userName);
}