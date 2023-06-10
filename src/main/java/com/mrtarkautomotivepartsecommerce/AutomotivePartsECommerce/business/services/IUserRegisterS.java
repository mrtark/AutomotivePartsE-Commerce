package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.services;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.dto.UserRegisterDto;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity.UserRegisterEntity;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface IUserRegisterS {
    UserRegisterDto EntityToDto(UserRegisterEntity userRegisterEntity);
    UserRegisterEntity DtoToEntity (UserRegisterDto userRegisterDto);
    ResponseEntity<UserRegisterDto> userRegisterCreate(UserRegisterDto userRegisterDto);
    ResponseEntity<List<UserRegisterDto>> userRegisterAll();
    ResponseEntity<?> findUserRegister(Long id);
    ResponseEntity<Map<String,Boolean>> deleteUser(Long id);
    ResponseEntity<UserRegisterDto> updateUser(Long id, UserRegisterDto userRegisterDto);

    String getProfile(String name);
    void getAllHeaderData(Map<String,String> header);
    String getRoot();
    ResponseEntity<?> getAppInfo(HttpServletRequest request, HttpServletResponse response);
}
