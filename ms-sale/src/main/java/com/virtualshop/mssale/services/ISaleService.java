package com.virtualshop.mssale.services;

import java.util.List;

import com.virtualshop.mssale.entities.Sale;
import com.virtualshop.mssale.entities.dtos.SaleInputDTO;

public interface ISaleService {
    
    public List<Sale> findAll();
    public Sale findByUserEmail(String email);
    public Sale findByProductId(Long id);
    public void saveSale(SaleInputDTO saleInputDTO);
    public void deleteSale(Long id);
}
