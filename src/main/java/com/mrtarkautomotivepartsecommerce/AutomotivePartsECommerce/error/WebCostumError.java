package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.error;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class WebCostumError implements ErrorController {
    private final ErrorAttributes errorAttributes;
    @RequestMapping("/error")
    public ApiResult catchErrors(WebRequest rfwebRequest){
        ApiResult error;
        int status;
        String message,path;

        Map<String, Object> errAttributes = errorAttributes.getErrorAttributes(rfwebRequest, ErrorAttributeOptions.of(
                ErrorAttributeOptions.Include.MESSAGE,ErrorAttributeOptions.Include.BINDING_ERRORS)
        );

        status = (Integer)errAttributes.get("status");
        message = (String)errAttributes.get("message");
        path = (String)errAttributes.get("path");
        error = new ApiResult(status,message,path);

        if(errAttributes.containsKey("errors")){
            List<FieldError> fieldErrorList =(List)errAttributes.get("errors");
            Map<String,String> validationMistakes = new HashMap<>();
            for (FieldError reffieldError: fieldErrorList) {
                validationMistakes.put(reffieldError.getField(),reffieldError.getDefaultMessage());
            }
            error.setValidationErrorss(validationMistakes);
        }
        return error;
    }

}
