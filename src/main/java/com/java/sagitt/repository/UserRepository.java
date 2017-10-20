package com.java.sagitt.repository;

import org.springframework.data.repository.CrudRepository;

import com.java.sagitt.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByEmail(String email);
}
