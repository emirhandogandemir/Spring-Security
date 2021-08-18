package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	 public Role findByName(String name); // isme göre var olan objeyi döndürüyor
}
