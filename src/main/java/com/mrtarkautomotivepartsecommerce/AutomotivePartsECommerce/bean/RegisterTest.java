package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.bean;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.dto.ProductDto;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.dto.UserRegisterDto;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity.ProductEntity;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity.UserRegisterEntity;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.repository.IProductRepository;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.repository.IUserRegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import java.util.Random;
import java.util.UUID;

@RequiredArgsConstructor
@Configuration
public class RegisterTest {
    private final ModelMapperBn modelMapperBn;
    private final IUserRegisterRepository userRegisterRepository;
    private final IProductRepository iProductRepository;
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
                        .email("mail" + UUID.randomUUID().toString().replaceAll("-", "").toUpperCase().substring(0,13).concat("@mrtark.com"))
                        .password(passwordEncodeBn.passwordEncoderMethod().encode("mrtark1234."))
                        .active("Check")
                        .build();
                UserRegisterEntity registerEntity =  modelMapperBn.modelMapperMethod().map(registerDTO,UserRegisterEntity.class);
                userRegisterRepository.save(registerEntity);
            }
        };
    }

    @Bean
    CommandLineRunner createProduct(){
        String applicationProperties1 = servletContext.getInitParameter("my_special.name");
        return (args)->{
            double l = 1D;
            double r = 10D;

            for (int i = 0; i <=3; i++) {
                Long random = (long) ((long) (l + new Random().nextDouble() * (r - l)) * (Math.random() *100));
                ProductDto productDto = ProductDto
                        .builder()
                        .partID(Long.valueOf(random))
                        .partName("TestPartN")
                        .description("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make")
                        .partPrice(Long.valueOf(random))
                        .partImage("link")
                        .build();
                ProductEntity product =  modelMapperBn.modelMapperMethod().map(productDto, ProductEntity.class);
                iProductRepository.save(product);
            }
        };
    }
}
