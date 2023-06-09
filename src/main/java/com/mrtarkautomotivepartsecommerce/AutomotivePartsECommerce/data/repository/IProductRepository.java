package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.repository;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductRepository extends JpaRepository<ProductEntity,Long> {
    ProductEntity findByPartID(Long id);
    Optional<ProductEntity> findById(Long id);

}
