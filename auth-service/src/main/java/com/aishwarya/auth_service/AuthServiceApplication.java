package com.aishwarya.auth_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthServiceApplication {

	public static void main(String[] args) {
		System.setProperty("spring.application.name", "auth-service");
		SpringApplication.run(AuthServiceApplication.class, args);
	}

}
