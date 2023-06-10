package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.services.IService;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.bean.ModelMapperBn;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.bean.PasswordEncodeBn;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.dto.UserRegisterDto;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.services.IUserRegisterS;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity.UserRegisterEntity;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.repository.IUserRegisterRepository;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.exceptions.ResourceNotFoundEx;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@RequiredArgsConstructor
@Log4j2
@Service
public class UserRegister implements IUserRegisterS {
    private final IUserRegisterRepository iUserRegisterRepository;
    private final ModelMapperBn modelMapperBn;
    private final PasswordEncodeBn passwordEncodeBn;


    @Override
    public UserRegisterDto EntityToDto(UserRegisterEntity userRegisterEntity) {
        return modelMapperBn.modelMapperMethod().map(userRegisterEntity, UserRegisterDto.class);
    }

    @Override
    public UserRegisterEntity DtoToEntity(UserRegisterDto userRegisterDto) {
        return modelMapperBn.modelMapperMethod().map(userRegisterDto, UserRegisterEntity.class);
    }

    @Transactional
    @Override
    public UserRegisterDto userRegisterCreate(UserRegisterDto userRegisterDto) {
        if (userRegisterDto != null) {
            userRegisterDto.setPassword(passwordEncodeBn.passwordEncoderMethod().encode(userRegisterDto.getPassword()));
            UserRegisterEntity entity = DtoToEntity(userRegisterDto);
            UserRegisterEntity userRegisterEntity = iUserRegisterRepository.save(entity);
            userRegisterDto.setId((userRegisterEntity.getId()));
            System.out.println(userRegisterEntity.getId() + ": ID Users Create Success!");
        }

        return userRegisterDto;
    }

    @Override
    public List<UserRegisterDto> userRegisterAll() {
        Iterable<UserRegisterEntity> userRegisterEntityList = iUserRegisterRepository.findAll();
        List<UserRegisterDto> dtoList = new ArrayList<>();
        for (UserRegisterEntity al : userRegisterEntityList) {
            UserRegisterDto dto = EntityToDto(al);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public UserRegisterDto findUserRegister(Long id) {
        UserRegisterEntity find = iUserRegisterRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundEx(id + ": ID Not Found!"));
        System.out.println(" [ " + find + " ] ");
        UserRegisterDto findDto = EntityToDto(find);
        return findDto;
    }

    @Override
    public Map<String, Boolean> deleteUser(Long id) {
        UserRegisterDto dto = findUserRegister(id);
        Map<String,Boolean> userDelete = new LinkedHashMap<>();
        if (dto != null){
            iUserRegisterRepository.delete(DtoToEntity(dto));
            userDelete.put(" [ " + dto + " ] ID Data Deleted!" , Boolean.TRUE);
        }
            return userDelete;
    }

    @Transactional
    @Override
    public UserRegisterDto updateUser(Long id, UserRegisterDto userRegisterDto) {
        UserRegisterDto dto = findUserRegister(id);
        if (dto != null) {
            dto.setName(userRegisterDto.getName());
            dto.setLastname(userRegisterDto.getLastname());
            dto.setEmail(userRegisterDto.getEmail());
            dto.setPassword(passwordEncodeBn.passwordEncoderMethod().encode(userRegisterDto.getPassword()));
            dto.setActive(userRegisterDto.getActive());
            UserRegisterEntity entity = DtoToEntity(dto);
            iUserRegisterRepository.save(entity);

            dto.setId((entity.getId()));
            System.out.println(entity.getId() + ": ID Users Update Success!");
        }
        return dto;
    }

    @Override
    public UserRegisterDto searchByEmail(String email) {
        UserRegisterEntity entity = iUserRegisterRepository.findByEmail(email);
        if (entity != null){
            UserRegisterDto dtoEmail = EntityToDto(entity);
            return dtoEmail;
        }
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
