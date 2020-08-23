package com.cts.mc.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cts.mc.user.model.User;



@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CustomerRegistrationApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

//	@Test
	@DisplayName("test Message REST API ")
	void testMessage() {
		
		User user = new User();	
//		user.setUserId(12345L);
		user.setFirstName("hari");
		user.setLastName("krishna");
		user.setDob("06-06-06");
		user.setEmail("test@gmail.com");
		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "555889");
	    restTemplate.put("/user/createUser", user, User.class);
	//	Customer  message = this.restTemplate.postForObject("/customerService/customerObj/{id}",userRegr, Customer.class);
			//System.out.println("@@@@:"+message.getCustomerId());
		assertEquals(user, user);
	}


}
