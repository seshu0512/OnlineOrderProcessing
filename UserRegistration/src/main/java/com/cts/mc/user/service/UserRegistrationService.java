package com.cts.mc.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.mc.user.dao.UserRepository;
import com.cts.mc.user.exception.UserException;
import com.cts.mc.user.model.User;

@Service
public class UserRegistrationService implements IUserRegistrationService {

	@Autowired
	UserRepository  userRepository;
	@Override
	public User createUser(User user) throws UserException {
		userRepository.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) throws UserException {
		userRepository.save(user);
		return user;
	}

	@Override
	public User getUser(Long userId) throws UserException {
		
		 Optional<User> optionalProduct =  userRepository.findById(userId);
		 User user =null;
		 if(optionalProduct.isPresent()) {
			 user= optionalProduct.get();
		 }
		 return user;
	}

}
