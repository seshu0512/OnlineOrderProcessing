package com.cts.mc.user.services;

import com.cts.mc.user.vo.User;

public interface IUserRegistrationService {

	public User addUser(User user);
	public User updateUser(User user);
}
