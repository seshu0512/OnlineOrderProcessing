package com.cts.mc.user.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.mc.user.repository.UserJsonRepository;
import com.cts.mc.user.vo.User;

@RestController
@RequestMapping("/user")
public class UserRegistrationService implements IUserRegistrationService {

	@Autowired
	RestTemplate restTemplate;

	static Logger log = Logger.getLogger(UserRegistrationService.class.getName());
	UserJsonRepository jsonRepository = new UserJsonRepository();

	@Override
	@RequestMapping("/createUser")
	public User addUser(@RequestBody User userobject) {

		log.debug("Adding user to Json repository");
		jsonRepository.readJson(userobject);
		return userobject;
	}

	@Override
	@RequestMapping("/updateUser")
	public User updateUser(@RequestBody User userobject) {
		log.debug("Updating user in Json repository");
		return userobject;
	}

}
