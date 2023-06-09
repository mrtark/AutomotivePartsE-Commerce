package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.TimeZone;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EntityScan(basePackages = "com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity")
@EnableJpaRepositories(basePackages = "com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.repository")
public class AutomotivePartsECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomotivePartsECommerceApplication.class, args);
	}

}
