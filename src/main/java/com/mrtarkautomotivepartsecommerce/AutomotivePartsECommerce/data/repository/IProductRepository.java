package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.repository;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductEntity,Long> {
    ProductEntity findByPartID(Long id);
}
