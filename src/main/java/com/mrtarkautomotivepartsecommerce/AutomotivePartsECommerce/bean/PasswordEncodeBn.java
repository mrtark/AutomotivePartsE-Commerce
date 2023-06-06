package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class PasswordEncodeBn {
    @Bean
    public PasswordEncoder passwordEncoderMethod(){
        return new BCryptPasswordEncoder();
    }
}
