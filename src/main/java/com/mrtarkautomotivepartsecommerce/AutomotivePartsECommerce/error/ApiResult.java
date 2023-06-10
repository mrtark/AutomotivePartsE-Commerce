package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult {
    private int status;
    private String error;
    private String message;
    private String path;
    private Date errDate = new Date(System.currentTimeMillis());
    private Map<String,String> validationErrorss;
    public ApiResult(int status, String error, String message, String path) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
    public ApiResult(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
    }
}
