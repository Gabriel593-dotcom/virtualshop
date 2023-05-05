package com.virtualshop.mssale.entities.dtos;

import com.virtualshop.mssale.entities.Sale;

public class SaleInputDTO {
    private String productId;
    private String productName;
    private Long userId;
    private String userEmail;
    private String userName;

    public SaleInputDTO() {
    }

    public SaleInputDTO(Sale sale) {
        this.productId = sale.getProductId();
        this.productName = sale.getProductName();
        this.userId = sale.getUserId();
        this.userEmail = sale.getUserEmail();
        this.userName = sale.getUserName();
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

}
