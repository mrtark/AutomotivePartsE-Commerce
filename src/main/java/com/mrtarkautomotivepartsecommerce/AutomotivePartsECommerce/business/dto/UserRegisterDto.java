package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.dto;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.annotation.UserRegisterUniqueEmailMy;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class UserRegisterDto {
    private Long id;
    @NotNull(message = "{register.name.validation.constraints.NotNull.message}")
    private String name;
    @NotNull(message = "{register.lastname.validation.constraints.NotNull.message}")
    private String lastname;
    @NotNull(message = "{register.email.validation.constraints.NotNull.messages}")
    @Email
    @Size(max = 100)
    @UserRegisterUniqueEmailMy
    private  String email;
    @NotNull(message = "{register.password.validation.constraints.NotNull.message}")
    @Size(min = 8)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).*$", message = "{\"{register.password.pattern.validation.constraints.NotNull.message}\"}")
    private String password;
    private String active;
}
