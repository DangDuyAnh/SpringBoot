package com.example.dataconnect.models;

import java.util.Date;

public class Store {
    private int id;
    private String storeCode;
    private String storeName;
    private String address;

    private Date createdDate;
    private Date modifiedDate;

    public Store() {
    }

    public Store(String storeCode, String storeName, String address) {
        this.storeCode = storeCode;
        this.storeName = storeName;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "Store [id=" + id + ", storeCode=" + storeCode + ", storeName=" + storeName + ", address=" + address + ", createdDate=" + createdDate
                + ", modifiedDate=" + modifiedDate + "]";
    }
}
