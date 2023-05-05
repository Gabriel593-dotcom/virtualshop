package com.virtualshop.mssale.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtualshop.mssale.entities.Sale;
import com.virtualshop.mssale.entities.dtos.SaleInputDTO;
import com.virtualshop.mssale.services.impl.SaleService;

@RestController
@RequestMapping(value = "/api/sales")
public class SaleController {
    
    @Autowired
    private SaleService service;
    
    @GetMapping 
    public ResponseEntity<List<Sale>> findAll() {
        List<Sale> sales = service.findAll();
        return ResponseEntity.ok().body(sales);
    }

    @GetMapping(value = "/findByProductId")
    public ResponseEntity<Sale> findSaleByProductId(@RequestParam(name = "productId") Long productId) {
        Sale sale = service.findByProductId(productId);
        return ResponseEntity.ok().body(sale);
    }


    @GetMapping(value = "/findByUserEmail")
    public ResponseEntity<Sale> findSaleByUserEmail(@RequestParam(name = "userEmail") String userEmail) {
        Sale sale = service.findByUserEmail(userEmail);
        return ResponseEntity.ok().body(sale);
    }

    @PostMapping(value = "/saveSale")
    public ResponseEntity<Void> saveSale(@RequestBody SaleInputDTO saleInputDTO) {
        service.saveSale(saleInputDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/deleteSale/{id}")
    public ResponseEntity<Void> deleteSaleById(@PathVariable Long id) {
        service.deleteSale(id);
        return ResponseEntity.noContent().build();
    }
}
