package com.springrolebasejwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrolebasejwt.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

	Role findByName(String name);
	
}
