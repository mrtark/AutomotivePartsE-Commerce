package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.services.IService;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.bean.ModelMapperBn;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.dto.ProductDto;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.services.IProducts;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.entity.ProductEntity;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.data.repository.IProductRepository;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.exceptions.ResourceNotFoundEx;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@Service
public class Product implements IProducts {
    private final IProductRepository iProductRepository;
    private final ModelMapperBn modelMapperBn;

    @Override
    public ProductDto EntityToDto(ProductEntity productEntity) {
        return modelMapperBn.modelMapperMethod().map(productEntity, ProductDto.class);
    }

    @Override
    public ProductEntity DtoToEntity(ProductDto productDto) {
        return modelMapperBn.modelMapperMethod().map(productDto, ProductEntity.class);
    }

    @Transactional
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        if (productDto != null) {
            ProductEntity product = DtoToEntity(productDto);
            ProductEntity sProduct = iProductRepository.save(product);
            System.out.println(sProduct.getId() + ": ID Product Create Success!");
        }
        return productDto;
    }

    @Override
    public List<ProductDto> products() {
        List<ProductDto> productDtoList = new ArrayList<>();
        List<ProductEntity> productEntityList = iProductRepository.findAll();
        for (ProductEntity all : productEntityList) {
            ProductDto dto = EntityToDto(all);
            productDtoList.add(dto);
        }
        return productDtoList;
    }

    @Override
    public ProductDto findProduct(Long id) {
        ProductEntity findProductEntity = iProductRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundEx(id + ": Product ID Not Found!")
        );
        ProductDto dto = EntityToDto(findProductEntity);
        return dto;
    }

    @Override
    public Map<String, Boolean> deleteProduct(Long id) {
        ProductDto dto = findProduct(id);
        Map<String, Boolean> deleteProduct = new LinkedHashMap<>();
        if (dto != null) {
            iProductRepository.delete(DtoToEntity(dto));
            deleteProduct.put(" [ " + dto + " ] ID Product Deleted!", Boolean.TRUE);
        }

        return deleteProduct;
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        ProductEntity findProductEntity = iProductRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundEx(id + ": Product ID Not Found!")
        );
        if (findProductEntity != null) {
            findProductEntity.setPartID(productDto.getPartID());
            findProductEntity.setPartName(productDto.getPartName());
            findProductEntity.setDescription(productDto.getDescription());
            findProductEntity.setPartPrice(productDto.getPartPrice());
            findProductEntity.setPartImage(productDto.getPartImage());
            iProductRepository.save(findProductEntity);
        }
        ProductDto upDto = EntityToDto(findProductEntity);
        return upDto;
    }

    @Override
    public ProductDto searchPartID(Long id) {
        ProductEntity entity = iProductRepository.findByPartID(id);
        if (entity != null) {
            ProductDto dto = EntityToDto(entity);
            return dto;
        }
        return null;
    }
}
