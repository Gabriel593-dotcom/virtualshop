package com.virtualshop.mssale.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualshop.mssale.entities.Product;
import com.virtualshop.mssale.entities.feignclients.ProductFeignClient;

@Service
public class ProductService {
    
    @Autowired
    private ProductFeignClient productFeignClient;

    public Product findProductById(Long id) {
        Product product = productFeignClient.findById(id).getBody();
        return product;
    }
}
