package com.example.dataconnect.models;

import java.util.Date;

public class Product {
    private int id;
    private int price;
    private String productCode;
    private int category;
    private int store;
    private String productName;
    private String descript;
    private String imageLink;
    private int valAmount;
    private int soldAmount;
    private Date createdDate;
    private Date modifiedDate;

    @Override
    public String toString() {
        return "Product [id=" + id + ", productCode=" + productCode + ", category=" + category +
                ", store=" + store + ", productName=" + productName + ", descript= " + descript
                + ", valAmount=" + valAmount + ", soldAmount " + soldAmount
                + ", price=" + price + ", createdDate=" + createdDate + ", modifiedDate= " + modifiedDate + "]";
    }

    public Product() {
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public int getValAmount() {
        return valAmount;
    }

    public void setValAmount(int valAmount) {
        this.valAmount = valAmount;
    }

    public int getSoldAmount() {
        return soldAmount;
    }

    public void setSoldAmount(int soldAmount) {
        this.soldAmount = soldAmount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
