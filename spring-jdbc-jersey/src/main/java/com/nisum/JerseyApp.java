package com.nisum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.nisum")
public class JerseyApp {
	public static void main(String[] args) {
		SpringApplication.run(JerseyApp.class, args);
	}
}
