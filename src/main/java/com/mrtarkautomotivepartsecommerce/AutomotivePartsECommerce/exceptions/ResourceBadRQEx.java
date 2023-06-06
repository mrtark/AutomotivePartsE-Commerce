package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceBadRQEx extends RuntimeException{
    public ResourceBadRQEx(String msj) {
        super(msj);
    }
}
