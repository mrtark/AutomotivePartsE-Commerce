package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UserRegisterUniqueEmailMyValidation.class})
public @interface UserRegisterUniqueEmailMy {
    String message() default "{register.email.unique.validation.constraints.NotNull.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
