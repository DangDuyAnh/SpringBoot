package com.example.dataconnect.models;

import java.util.Date;

public class Category {
    private int id;
    private String categoryCode;
    private String categoryName;
    private String descript;
    private Date createdDate;
    private Date modifiedDate;

    public Category(){

    }
    public Category(String categoryCode, String categoryName, String descript) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.descript = descript;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
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
        return "Category [id=" + id + ", categoryCode=" + categoryCode + ", categoryName=" + categoryName +
                ", descript=" + descript + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
    }
}
