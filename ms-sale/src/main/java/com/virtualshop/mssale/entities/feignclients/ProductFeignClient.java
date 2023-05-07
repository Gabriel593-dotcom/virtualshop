package com.virtualshop.mssale.entities.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.virtualshop.mssale.entities.Product;

@Component
@FeignClient(name = "ms-product", path = "/api/products")
public interface ProductFeignClient {
    
    @GetMapping(value = "/{id}") 
    ResponseEntity<Product> findById(@PathVariable Long id);
}
