package com.cts.mc.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
//@EnableEurekaClient
public class UserRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationApplication.class, args);
	}
	@Bean
//	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}

