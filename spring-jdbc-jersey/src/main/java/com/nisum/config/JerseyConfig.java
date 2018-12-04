package com.nisum.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.nisum.controller.EmployeeController;

@Component
@ApplicationPath("/spring-app")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(EmployeeController.class);
	}
}
