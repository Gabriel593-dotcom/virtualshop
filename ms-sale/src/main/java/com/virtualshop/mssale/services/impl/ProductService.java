package com.virtualshop.mssale.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualshop.mssale.entities.Product;
import com.virtualshop.mssale.entities.feignclients.ProductFeignClient;
import com.virtualshop.mssale.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductFeignClient productFeignClient;

    public Product findProductById(Long id) {
        Product product = productFeignClient.findById(id).getBody();
        if(product.getId() == 0) {
            throw new ResourceNotFoundException("Produto com o id " + id + " não encontrado.");
        }
        return product;
    }
}
