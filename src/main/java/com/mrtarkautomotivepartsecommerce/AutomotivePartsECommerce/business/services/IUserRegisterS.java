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
    UserRegisterDto userRegisterCreate(UserRegisterDto userRegisterDto);
    List<UserRegisterDto> userRegisterAll();
    UserRegisterDto findUserRegister(Long id);
    Map<String,Boolean> deleteUser(Long id);
    UserRegisterDto updateUser(Long id, UserRegisterDto userRegisterDto);
    UserRegisterDto searchByEmail(String email);

    String getProfile(String name);
    void getAllHeaderData(Map<String,String> header);
    String getRoot();
    ResponseEntity<?> getAppInfo(HttpServletRequest request, HttpServletResponse response);
}
