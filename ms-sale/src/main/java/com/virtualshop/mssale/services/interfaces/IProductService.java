package com.virtualshop.mssale.services.interfaces;

import com.virtualshop.mssale.entities.Product;

public interface IProductService {
    Product findById(Long id);
}
