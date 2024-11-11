package com.example.dataconnect.dto;

public class CategoryWithAmountDto {
    private int id;
    private String categoryCode;
    private String categoryName;
    private String descript;
    private int amount;

    public CategoryWithAmountDto() {
    }

    public CategoryWithAmountDto(int id, String categoryCode, String categoryName, String descript, int amount) {
        this.id = id;
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.descript = descript;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}