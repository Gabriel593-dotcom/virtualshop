package com.virtualshop.mssale.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualshop.mssale.entities.Sale;
import com.virtualshop.mssale.entities.dtos.SaleInputDTO;
import com.virtualshop.mssale.repositories.SaleRepository;
import com.virtualshop.mssale.services.interfaces.ISaleService;

@Service
public class SaleService implements ISaleService{
    
    @Autowired
    private SaleRepository repo;

    @Override
    public List<Sale> findAll() {
        return repo.findAll();
    }

    @Override
    public Sale findByUserEmail(String email) {
        return repo.findByUserEmail(email); 
    }

    @Override
    public Sale findByProductId(Long id) {
        return repo.findByProductId(id);
    }

    @Override
    @Transactional
    public void saveSale(SaleInputDTO saleInputDTO) {
        Sale sale = saleInputDTOToSale(saleInputDTO);
        repo.save(sale);
    }

    @Override
    public void deleteSale(Long id) {
        repo.deleteById(id);
    }    

    private Sale saleInputDTOToSale(SaleInputDTO saleInputDTO) {
        return new Sale(null, saleInputDTO.getProductId(), saleInputDTO.getProductName(), saleInputDTO.getUserId(), saleInputDTO.getUserEmail(), saleInputDTO.getUserName());
    }
}
