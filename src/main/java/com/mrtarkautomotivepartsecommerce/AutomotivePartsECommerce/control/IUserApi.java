package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.control;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.dto.UserRegisterDto;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface IUserApi {
    String getProfile(String name);
    void getAllHeaderData(Map<String,String> header);
    String getRoot();
    ResponseEntity<?> getAppInfo(HttpServletRequest request, HttpServletResponse response);
    ResponseEntity<UserRegisterDto> createUser(UserRegisterDto userRegisterDto);

    ResponseEntity<List<UserRegisterDto>> userList();

    ResponseEntity<?> findUser(Long id);

    ResponseEntity<Map<String, Boolean>> deleteUser(Long id);

    ResponseEntity<UserRegisterDto> updateUser(Long id, UserRegisterDto userRegisterDto);

}
