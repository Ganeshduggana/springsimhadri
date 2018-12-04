package com.springbootlogin.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootlogin.model.Role;
import com.springbootlogin.model.User;
import com.springbootlogin.repository.RoleRepository;
import com.springbootlogin.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
 @Autowired
 private UserRepository userRepository;
 @Autowired
 private RoleRepository roleRepository;

 public void save(User user) {
 user.setPassword(user.getPassword());
 user.setRoles(new HashSet<Role>(roleRepository.findAll()));
 userRepository.save(user);
 }

 public User findByUsername(String username) {
 return userRepository.findByUsername(username);
 }
 }
