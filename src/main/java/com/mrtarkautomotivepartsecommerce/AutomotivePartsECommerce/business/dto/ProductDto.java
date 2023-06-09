package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.dto;

import javax.validation.constraints.NotNull;

public class ProductDto {
    private Long id;
    @NotNull(message = "{product.partID.validation.constraints.NotNull.message}")
    private Long partID;
    @NotNull(message = "{product.partName.validation.constraints.NotNull.message}")
    private String partName;
    @NotNull(message = "{product.description.validation.constraints.NotNull.message}")
    private String description;
    @NotNull(message = "{product.partPrice.validation.constraints.NotNull.message}")
    private Long partPrice;
    private String partImage;


}
