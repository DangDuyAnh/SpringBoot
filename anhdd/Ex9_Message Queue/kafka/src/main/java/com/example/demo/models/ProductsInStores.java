package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "products_in_stores")
public class ProductsInStores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public ProductsInStores(int id, int store, int productNum, Date createdDate) {
        this.id = id;
        this.store = store;
        this.productNum = productNum;
        this.createdDate = createdDate;
    }

    public ProductsInStores(int store, int productNum, Date createdDate) {
        this.store = store;
        this.productNum = productNum;
        this.createdDate = createdDate;
    }

    public ProductsInStores() {
    }

    private int store;

    @Column(name = "product_num")
    private int productNum;

    @Column(name = "created_date")
    private Date createdDate;
}
