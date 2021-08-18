package com.springrolebasejwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrolebasejwt.domain.User;


public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUsername(String username);
	
}
