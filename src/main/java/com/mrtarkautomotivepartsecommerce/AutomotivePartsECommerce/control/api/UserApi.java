package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.control.api;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.dto.UserRegisterDto;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.services.IUserRegisterS;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.control.IUserApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
@RequiredArgsConstructor
@Log4j2
@RestController
@RequestMapping("/api/user/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class UserApi implements IUserApi {
    private final IUserRegisterS iUserRegisterS;

    @Override
    @GetMapping("/profile/{data}")
    public String getProfile(@PathVariable(name="data") String name) {
        log.info(name);
        return null;
    }

    @Override
    public void getAllHeaderData(Map<String, String> header) {

    }

    @Override
    @GetMapping({"/","/index"})
    public String getRoot() {
        return "index";
    }

    @Override
    public ResponseEntity<?> getAppInfo(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public ResponseEntity<UserRegisterDto> createUser(UserRegisterDto userRegisterDto) {
        return null;
    }

    @Override
    public ResponseEntity<List<UserRegisterDto>> userList() {
        return null;
    }

    @Override
    public ResponseEntity<?> findUser(Long id) {
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
}
