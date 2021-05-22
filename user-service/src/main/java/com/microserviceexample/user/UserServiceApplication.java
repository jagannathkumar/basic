package com.microserviceexample.user;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		/*
		 * SpringApplication app = new SpringApplication(UserServiceApplication.class);
		 * app.setDefaultProperties(Collections.singletonMap("server.port", "9002"));
		 * app.run(args);
		 */
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
