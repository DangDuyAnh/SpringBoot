package com.example.dataconnect.dto;

public class ProductWithCategoryBody {
    private String categoryName;
    private String productName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductWithCategoryBody(String categoryName, String productName) {
        this.categoryName = categoryName;
        this.productName = productName;
    }
}