package com.springbootlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootlogin.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
