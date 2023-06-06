package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CREATED)
public class ResourceCreatedEx extends RuntimeException{
    public ResourceCreatedEx(String msj) {
        super(msj);
    }
}
