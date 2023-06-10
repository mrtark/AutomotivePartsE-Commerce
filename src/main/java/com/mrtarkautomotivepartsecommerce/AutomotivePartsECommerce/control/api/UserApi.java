package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.control.api;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.annotation.UserRegisterUniqueEmailMyValidation;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.dto.UserRegisterDto;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.services.IUserRegisterS;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.control.IUserApi;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.error.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
    public String getProfile(@PathVariable(name = "data") String name) {
        log.info(name);
        return null;
    }

    @Override
    public void getAllHeaderData(Map<String, String> header) {

    }

    @Override
    @GetMapping({"/", "/index"})
    public String getRoot() {
        return "index";
    }

    @Override
    public ResponseEntity<?> getAppInfo(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    // http://localhost:8080/api/user/v1/createUser
    @Override
    @PostMapping("/createUser")
    public ResponseEntity<UserRegisterDto> createUser(@Valid @RequestBody UserRegisterDto userRegisterDto) {
        return ResponseEntity.ok(iUserRegisterS.userRegisterCreate(userRegisterDto));
    }

    // http://localhost:8080/api/user/v1/userList
    @Override
    @GetMapping("/userList")
    public ResponseEntity<List<UserRegisterDto>> userList() {
        return ResponseEntity.ok(iUserRegisterS.userRegisterAll());
    }

    // http://localhost:8080/api/user/v1/userDel
    // http://localhost:8080/api/user/v1/userDel/0
    // http://localhost:8080/api/user/v1/userDel/1
    // http://localhost:8080/api/user/v1/userDel/-1
    @Override
    @GetMapping({"/userDel", "/userDel/{id}"})
    public ResponseEntity<?> findUser(@PathVariable(name = "id", required = false) Long id) {
        if (id == null) {
            log.error("404 Not Found!");
            return ResponseEntity.notFound().build();
        } else if (id == 0) {
            log.error("400 Bad Request!");
            return ResponseEntity.badRequest().body("Bad Request!!");
        } else if (id < 0) {
            log.error("401 Bad Request!");
            ApiResult apiResult = ApiResult.builder()
                    .error("401")
                    .message("unAuthorized")
                    .path("http://localhost:8080/api/user/v1/-1")
                    .build();
            return ResponseEntity.status(401).body(apiResult);
        }
        log.info("Data With id: [ " + id + " ] Found!" + "\n" +
                iUserRegisterS.findUserRegister(id));
        return ResponseEntity.ok(iUserRegisterS.findUserRegister(id));
    }

    // http://localhost:8080/api/user/v1/userDel/0
    @Override
    @DeleteMapping({"/userDel", "/userDel/{id}"})
    public ResponseEntity<Map<String, Boolean>> deleteUser(Long id) {
        if (id == null) {
            log.error("404 Not Found!");
            return ResponseEntity.notFound().build();
        } else if (id == 0) {
            log.error("400 Bad Request!");
            return ResponseEntity.badRequest().build();
        }
        log.info("Data With id: [ " + id + " ] Found!" + "\n" +
                iUserRegisterS.findUserRegister(id));
        return ResponseEntity.ok(iUserRegisterS.deleteUser(id));
    }

    @Override
    @PutMapping({"/userUp", "/userUp/{id}"})
    public ResponseEntity<UserRegisterDto> updateUser(@PathVariable(name = "id", required = false) Long id,
                                                      @Valid @RequestBody UserRegisterDto userRegisterDto) {
        if (id == null) {
            log.error("404 Not Found!");
            return ResponseEntity.notFound().build();
        } else if (id == 0) {
            log.error("400 Bad Request!");
            return ResponseEntity.badRequest().build();
        }
        log.info("Data With id: [ " + id + " ] Found!" + "\n" +
                iUserRegisterS.findUserRegister(id));
        return ResponseEntity.ok(iUserRegisterS.updateUser(id,userRegisterDto));
    }
}
