package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.services.IService;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.dto.UserRegisterDto;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.services.IUserRegisterS;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity.UserRegisterEntity;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class UserRegister implements IUserRegisterS {


    @Override
    public UserRegisterDto EntityToDto(UserRegisterEntity userRegisterEntity) {
        return null;
    }

    @Override
    public UserRegisterEntity DtoToEntity(UserRegisterDto userRegisterDto) {
        return null;
    }

    @Override
    public ResponseEntity<UserRegisterDto> userRegisterCreate(UserRegisterDto userRegisterDto) {
        return null;
    }

    @Override
    public ResponseEntity<List<UserRegisterDto>> userRegisterAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> findUserRegister(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteUser(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<UserRegisterDto> updateUser(Long id, UserRegisterDto userRegisterDto) {
        return null;
    }

    @Override
    public String getProfile(String name) {
        return null;
    }

    @Override
    public void getAllHeaderData(Map<String, String> header) {

    }

    @Override
    public String getRoot() {
        return null;
    }

    @Override
    public ResponseEntity<?> getAppInfo(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
