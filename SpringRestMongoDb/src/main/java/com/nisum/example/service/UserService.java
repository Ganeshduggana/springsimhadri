package com.nisum.example.service;

import java.util.List;

import com.nisum.example.model.User;

public interface UserService {
	public void createUser(User user);
	public User findById(String id);
	public User update(User user, String id);
	public List<User> getUsers();
	public void deleteUserById(String id);

}
