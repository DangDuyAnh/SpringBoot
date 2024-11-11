package com.example.dataconnect.dto;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductWithCategoryMapper implements RowMapper<ProductWithCategory> {

    @Override
    public ProductWithCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductWithCategory productWithCategory = new ProductWithCategory();
        productWithCategory.setId(rs.getInt("id"));
        productWithCategory.setCategoryName(rs.getString("category_name"));
        productWithCategory.setProductName(rs.getString("product_name"));
        productWithCategory.setProductCode(rs.getString("product_code"));
        productWithCategory.setPrice(rs.getInt("price"));
        return productWithCategory;
    }
}
