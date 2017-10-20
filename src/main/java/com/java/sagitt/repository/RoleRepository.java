package com.java.sagitt.repository;

import org.springframework.data.repository.CrudRepository;

import com.java.sagitt.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findByName(String name);
}
