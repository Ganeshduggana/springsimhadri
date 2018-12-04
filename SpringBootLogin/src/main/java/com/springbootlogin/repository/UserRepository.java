package com.springbootlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootlogin.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	 User findByUsername(String username);
	}  
