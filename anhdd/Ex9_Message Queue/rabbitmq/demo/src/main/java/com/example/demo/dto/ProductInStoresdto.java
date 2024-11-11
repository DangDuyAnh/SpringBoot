package com.example.demo.dto;

import java.util.Date;

public class ProductInStoresdto {
    private int store;
    private int productNum;
    private Date createdDate;

    public ProductInStoresdto(int store, int productNum, Date createdDate) {
        this.store = store;
        this.productNum = productNum;
        this.createdDate = createdDate;
    }

    public ProductInStoresdto() {
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
