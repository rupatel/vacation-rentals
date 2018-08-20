package com.neu.academic.travel.vacation.rentals.repositories.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neu.academic.travel.vacation.rentals.models.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
