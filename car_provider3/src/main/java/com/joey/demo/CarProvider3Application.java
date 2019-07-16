package com.joey.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CarProvider3Application {

	public static void main(String[] args) {
		SpringApplication.run(CarProvider3Application.class, args);
	}

}
