package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPIMethod(){
        return new OpenAPI().info( new Info()
                .title("AutomotivePartsE-Commerce")
                .description("AutomotivePartsE-Commerce Backend Project")
                .version("V1.0")
                .contact(new Contact()
                        .name("Murat")
                        .url("www.mrtark.com")
                        .email("contact@mrtark.com"))
                .termsOfService("www.mrtark.com")
                .license(new License()
                        .name("Licence ")
                        .url("www.mrtark.com"))
        );
    }
}
