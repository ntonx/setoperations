package com.example.sets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SetsApplication.class, args);
	}
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(SetsApplication.class);
	}
	
}
