package com.virtualshop.mssale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtualshop.mssale.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{
    Sale findByUserEmail(String email);    
    Sale findByProductId(Long id);
}
