package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.annotation;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity.UserRegisterEntity;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.repository.IUserRegisterRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UserRegisterUniqueEmailMyValidation implements ConstraintValidator<UserRegisterUniqueEmailMy,String> {
    final IUserRegisterRepository iUserRegisterRepository;
    public boolean isValid(String email, ConstraintValidatorContext context){
        UserRegisterEntity userRegisterEntity = iUserRegisterRepository.findByEmail(email);
        if (userRegisterEntity!= null)
            return false;
        return true;
    }
}
