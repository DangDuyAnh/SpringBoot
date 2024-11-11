package com.example.dataconnect.repositories;

import com.example.dataconnect.dto.ProductWithCategoryMapper;
import com.example.dataconnect.dto.ProductWithCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@org.springframework.stereotype.Repository
public class ProductWithCategoryRepository implements Repository<ProductWithCategory> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ProductWithCategory insert(ProductWithCategory model) {
        return null;
    }

    @Override
    public ProductWithCategory update(ProductWithCategory model) {
        return null;
    }

    @Override
    public ProductWithCategory findById(int id) {
        return null;
    }

    @Override
    public List<ProductWithCategory> findAll() {
        return null;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    public List<ProductWithCategory> findWithProductNameAndCategory() {
        return jdbcTemplate.query("SELECT P.id, product_name, price, product_code, category_name " +
                "FROM products P INNER JOIN categories C " +
                "ON P.category = C.id " +
                "where C.category_name = 'Apple' " +
                "AND P.product_name LIKE '%Điện thoại%'", new ProductWithCategoryMapper());
    }

    public List<ProductWithCategory> findWithProductNameAndCategory(String categoryName, String productName) {
        return jdbcTemplate.query("SELECT P.id, product_name, price, product_code, category_name " +
                "FROM products P INNER JOIN categories C " +
                "ON P.category = C.id " +
                "where C.category_name = ? " +
                "AND P.product_name LIKE ?", new ProductWithCategoryMapper(), new Object[]{categoryName, productName});
    }
}
