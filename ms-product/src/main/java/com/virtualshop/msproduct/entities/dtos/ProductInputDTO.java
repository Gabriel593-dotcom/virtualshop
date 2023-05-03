package com.virtualshop.msproduct.entities.dtos;

import com.virtualshop.msproduct.entities.Product;

public class ProductInputDTO {
    
    private String name;
    private Double price;
    private Integer quantity;

    public ProductInputDTO() {
    }

    public ProductInputDTO(Product product) {
        name = product.getName();
        price = product.getPrice();
        quantity = product.getQuantity();
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
