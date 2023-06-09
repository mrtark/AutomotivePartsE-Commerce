package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.repository;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IRoleRepository extends JpaRepository<RoleEntity,Long> {
    RoleEntity findByRole(@Param("role") String role);

}
