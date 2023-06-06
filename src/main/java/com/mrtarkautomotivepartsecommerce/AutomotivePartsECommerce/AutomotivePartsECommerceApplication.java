package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.TimeZone;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AutomotivePartsECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomotivePartsECommerceApplication.class, args);
	}

}
