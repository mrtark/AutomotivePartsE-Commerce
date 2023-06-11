package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.control;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.dto.ProductDto;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.dto.UserRegisterDto;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity.ProductEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IProductApi {
    ResponseEntity<ProductDto> createProduct(ProductDto productDto);

    ResponseEntity<List<ProductDto>> listProduct();

    ResponseEntity<?> findProduct(Long id);

    ResponseEntity<Map<String, Boolean>> deleteProduct(Long id);

    ResponseEntity<ProductDto> updateProduct(Long id, ProductDto productDto);
    ResponseEntity<ProductDto> productIdFind(Long id);
}
