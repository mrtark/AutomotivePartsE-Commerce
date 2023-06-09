package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.repository;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity.UserRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRegisterRepository extends JpaRepository<UserRegisterEntity,Long> {
    UserRegisterEntity findByEmail(String email);
    Optional<UserRegisterEntity> findByLastname(@Param("lastname") String username);

}
