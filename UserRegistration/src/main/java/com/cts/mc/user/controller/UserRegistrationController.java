package com.cts.mc.user.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.mc.user.exception.UserException;
import com.cts.mc.user.model.User;
import com.cts.mc.user.service.UserRegistrationService;

@RestController
@RequestMapping("/user")
public class UserRegistrationController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	UserRegistrationService userRegistrationService;

	static Logger log = Logger.getLogger(UserRegistrationController.class.getName());
	
	@CachePut(value = "users", key = "#user.userId")
	@PostMapping("/createUser")
	public ResponseEntity<String> createUser(@RequestBody User user) throws UserException {
		System.out.println("Adding user to Json repository for userId "+user.getUserId());
		log.debug("Adding user to Json repository for userId "+user.getUserId());
		 userRegistrationService.createUser(user);
		 return ResponseEntity.status(HttpStatus.CREATED).body("User Creaed Successfully");
		
	}
	@CachePut(value = "users", key = "#user.userId")
	@PutMapping("/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody User user) throws UserException {
		log.debug("Updating existing user"+ user.getUserId());
		userRegistrationService.updateUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("User Creaed Successfully");
		
	}
	@Cacheable(value = "users", key = "#userId")
	@GetMapping("/get/{userId}")
	public User updateUser(@PathVariable Long userId) throws UserException {
		log.debug("getting Useerdetails for "+ userId);
		return userRegistrationService.getUser(userId);
		
	}

}
