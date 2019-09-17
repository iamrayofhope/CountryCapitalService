package com.himanshu.continentNameService.ContinentNameService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ContinentNameServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContinentNameServiceApplication.class, args);
	}
}
