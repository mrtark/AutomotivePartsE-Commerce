package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.repository;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity.UserRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRegisterRepository extends JpaRepository<UserRegisterEntity,Long> {
    UserRegisterEntity findByEmail(String email);
}
