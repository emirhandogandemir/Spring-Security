package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username); // kullanıcı adına göre userı döndürücek

	boolean existsByUsername(String username); // username göre olup olmamasına göre true yada false dönücek
}
