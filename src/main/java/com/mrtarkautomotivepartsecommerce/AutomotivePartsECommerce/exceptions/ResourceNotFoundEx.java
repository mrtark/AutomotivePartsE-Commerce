package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundEx extends RuntimeException{
    public ResourceNotFoundEx(String msj) {
        super(msj);
    }
}
