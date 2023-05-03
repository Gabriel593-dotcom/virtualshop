package com.virtualshop.msproduct.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualshop.msproduct.entities.Product;
import com.virtualshop.msproduct.entities.dtos.ProductInputDTO;
import com.virtualshop.msproduct.services.ProductService;


@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = service.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = service.findById(id);
        return ResponseEntity.ok().body(product);
    }

    @PostMapping(value = "/saveProduct")
    public ResponseEntity<Void> postMethodName(@RequestBody ProductInputDTO productDTO) {
        service.saveProduct(productDTO);        
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping(value = "/deleteProduct/{id}") 
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/updateProduct/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody ProductInputDTO productDTO) {
        service.updateProduct(productDTO, id);
        return ResponseEntity.noContent().build();        
    }
}
