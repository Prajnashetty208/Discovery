package com.order.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
public class DiscoveryApplicationTests {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryApplicationTests.class, args);
	}

}
