package com.nisum.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.example.exception.UserNotFoundException;
import com.nisum.example.model.User;
import com.nisum.example.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	UserService userService;

	@PostMapping(value = "/users/create")
	public ResponseEntity<User> create(@Valid @RequestBody User user, BindingResult bindingResult) {

		logger.info("Creating New User");

		User userExists = userService.findById(user.getId());

		if (userExists != null) {
			logger.debug("Already a user registered with the id provided");
			bindingResult.rejectValue("id", "error.user", "There is already a user registered with the id provided");
			// return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			throw new UserNotFoundException("Already a user registered with the id provided");
		}
		if (bindingResult.hasErrors()) {
			System.out.println("Error occured");
		}

		else {
			userService.createUser(user);
			logger.info(" User--" + user);
		}
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}

	@SuppressWarnings("null")
	@GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
		logger.info("Fetching User with id " + id);

		User user = userService.findById(id);
		if (user == null) {
			logger.debug("user id is null" + user.getId());
			// return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			throw new UserNotFoundException("nottt");
		}
		logger.info(user.getId() + " " + user.getName() + " " + user.getEmail());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PutMapping(value = "/users/", headers = "Accept=application/json")
	public ResponseEntity<String> updateUser(@Valid @RequestBody User currentUser) {

		logger.info("updating  User with id " + currentUser.getId());

		User user = userService.findById(currentUser.getId());
		if (user == null) {

			logger.debug("user data chck once");

			throw new UserNotFoundException("please update your id");
			// return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		userService.update(currentUser, currentUser.getId());

		logger.info(user.getId() + " " + user.getName() + " " + user.getEmail());
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@GetMapping(value = "/users")
	public List<User> getAllUser() {

		List<User> usersList = userService.getUsers();
		return usersList;

	}

	@DeleteMapping(value = "/users/{id}", headers = "Accept=application/json")
	public ResponseEntity<User> deleteUser(@PathVariable("id") String id) {

		logger.info("deleting  User with id " + id);

		User user = userService.findById(id);
		if (user == null) {

			logger.debug("user id null");

			throw new UserNotFoundException("User Not found: " + id);

			// return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);

		logger.info("user successfully deleted");
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}
