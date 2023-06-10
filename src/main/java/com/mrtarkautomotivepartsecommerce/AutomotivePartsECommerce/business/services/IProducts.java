package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.services;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.dto.ProductDto;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity.ProductEntity;

import java.util.List;
import java.util.Map;

public interface IProducts {
    ProductDto EntityToDto(ProductEntity productEntity);
    ProductEntity DtoToEntity(ProductDto productDto);
    ProductDto createProduct(ProductDto productDto);
    List<ProductDto> products();
    ProductDto findProduct(Long id);
    Map<String,Boolean> deleteProduct(Long id);
    ProductDto updateProduct(Long id, ProductDto productDto);
    ProductDto searchPartID(Long id);
}
