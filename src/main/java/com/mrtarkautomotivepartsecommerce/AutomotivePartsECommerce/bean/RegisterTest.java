package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.bean;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.dto.UserRegisterDto;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity.UserRegisterEntity;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.repository.IUserRegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import java.util.UUID;

@RequiredArgsConstructor
@Configuration
public class RegisterTest {
    private final ModelMapperBn modelMapperBn;
    private final IUserRegisterRepository userRegisterRepository;
    @Value("${data.test.surname}")
    private String  MessagesProperties;
    private final PasswordEncodeBn passwordEncodeBn;
    private final ServletContext servletContext;
    @Bean
    CommandLineRunner createXRegister(){
        String applicationProperties = servletContext.getInitParameter("my_special.name");
        return (args)->{
            for (int i = 0; i <=3; i++) {
                UserRegisterDto registerDTO = UserRegisterDto
                        .builder()
                        .name("Murat")
                        .lastname("Arık")
                        .email(UUID.randomUUID().toString().toLowerCase().concat("@mrtark.com"))
                        .password(passwordEncodeBn.passwordEncoderMethod().encode("mrtark1234."))
                        .active("Check")
                        .build();
                UserRegisterEntity registerEntity =  modelMapperBn.modelMapperMethod().map(registerDTO,UserRegisterEntity.class);
                userRegisterRepository.save(registerEntity);
            }
        };
    }
}
