package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperBn {
    @Bean
    public ModelMapper modelMapperMethod(){
        return new ModelMapper();
    }
}
