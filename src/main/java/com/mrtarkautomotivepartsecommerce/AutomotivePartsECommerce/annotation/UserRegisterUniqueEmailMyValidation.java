package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.annotation;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity.UserRegisterEntity;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.repository.IUserRegisterRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@NoArgsConstructor
public class UserRegisterUniqueEmailMyValidation implements ConstraintValidator<UserRegisterUniqueEmailMy,String> {
    @Autowired
    IUserRegisterRepository iUserRegisterRepository;

    private String data="";
    public String result(String requestData){
        data=requestData;
        return data;
    }
    public boolean isValid(String email, ConstraintValidatorContext context){
        UserRegisterEntity userRegisterEntity = iUserRegisterRepository.findByEmail(email);
        if (userRegisterEntity!= null)
            return false;
        return true;
    }
}
