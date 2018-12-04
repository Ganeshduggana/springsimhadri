package com.nisum.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.example.model.User;
import com.nisum.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	public void createUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		
	}

	public User findById(String id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	public User update(User user, String id) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void deleteUserById(String id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}

}
