package com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.control.api;

import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.dto.ProductDto;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.business.services.IProducts;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.control.IProductApi;
import com.mrtarkautomotivepartsecommerce.AutomotivePartsECommerce.error.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
@RequiredArgsConstructor
@Log4j2
@RestController
@RequestMapping("/api/product/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductApi implements IProductApi {
    private final IProducts iProducts;

    // http://localhost:8080/api/product/v1/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(iProducts.createProduct(productDto));
    }

    // http://localhost:8080/api/product/v1/list
    @Override
    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> listProduct() {
        return ResponseEntity.ok(iProducts.products());
    }

    @Override
    @GetMapping({"/product", "/product/{id}"})
    public ResponseEntity<?> findProduct(@PathVariable(name = "id", required = false) Long id) {
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
                    .path("http://localhost:8080/api/product/v1/-1")
                    .build();
            return ResponseEntity.status(401).body(apiResult);
        }
        log.info("Data With id: [ " + id + " ] Found!" + "\n" +
                iProducts.findProduct(id));
        return ResponseEntity.ok(iProducts.findProduct(id));
    }

    @Override
    @DeleteMapping({"/product", "/product/{id}"})
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable(name = "id", required = false) Long id) {
        if (id == null) {
            log.error("404 Not Found!");
            return ResponseEntity.notFound().build();
        } else if (id == 0) {
            log.error("400 Bad Request!");
            return ResponseEntity.badRequest().build();
        }
        log.info("Data With id: [ " + id + " ] Found!" + "\n" +
                iProducts.findProduct(id)+ "\n" + "Deleted!");
        return ResponseEntity.ok(iProducts.deleteProduct(id));
    }

    @Override
    @PutMapping({"/product", "/product/{id}"})
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(name = "id", required = false) Long id,
                                                    @Valid @RequestBody ProductDto productDto) {
        if (id == null) {
            log.error("404 Not Found!");
            return ResponseEntity.notFound().build();
        } else if (id == 0) {
            log.error("400 Bad Request!");
            return ResponseEntity.badRequest().build();
        }
        log.info("Data With id: [ " + id + " ] Found!" + "\n" +
                iProducts.findProduct(id)+ "\n" + "Updated!");
        return ResponseEntity.ok(iProducts.updateProduct(id,productDto));
    }

    @Override
    @GetMapping({"/productID", "/productID/{id}"})
    public ResponseEntity<ProductDto> productIdFind(@PathVariable(name = "id", required = false)Long id) {
        if (id != null) {
            return ResponseEntity.ok(iProducts.searchPartID(id));
        }
        log.error("404 Not Found!");
        return ResponseEntity.notFound().build();
    }
}
