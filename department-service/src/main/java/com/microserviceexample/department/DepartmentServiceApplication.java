package com.microserviceexample.department;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		/*
		 * SpringApplication app = new
		 * SpringApplication(DepartmentServiceApplication.class);
		 * app.setDefaultProperties(Collections.singletonMap("server.port", "9001"));
		 * app.run(args);
		 */
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
