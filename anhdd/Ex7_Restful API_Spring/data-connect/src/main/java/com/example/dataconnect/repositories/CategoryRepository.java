package com.example.dataconnect.repositories;

import com.example.dataconnect.models.Category;
import com.example.dataconnect.models.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.util.List;

@org.springframework.stereotype.Repository
public class CategoryRepository implements Repository<Category> {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Category insert(Category model) {
        String sql = "INSERT INTO categories (category_code, category_name, descript)" +
                " VALUES (:categoryCode, :categoryName, :descript)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource namedParameter = new BeanPropertySqlParameterSource(model);
        namedParameterJdbcTemplate.update(sql, namedParameter, keyHolder, new String[]{"id"});

        SqlParameterSource namedParameter2 = new MapSqlParameterSource().addValue("id", keyHolder.getKey());
        Category _category = namedParameterJdbcTemplate.queryForObject("SELECT * FROM categories WHERE id= :id",
                namedParameter2, BeanPropertyRowMapper.newInstance(Category.class));
        return _category;
    }

    @Override
    public Category update(Category model) {
        String sql = "UPDATE categories SET category_code = :categoryCode, category_name= :categoryName," +
                        " descript= :descript WHERE id= :id";
        SqlParameterSource namedParameter = new BeanPropertySqlParameterSource(model);
        namedParameterJdbcTemplate.update(sql, namedParameter);

        Category _category = namedParameterJdbcTemplate.queryForObject("SELECT * FROM categories WHERE id= :id",
                namedParameter, BeanPropertyRowMapper.newInstance(Category.class));
        return _category;
    }

    @Override
    public Category findById(int id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        Category category = namedParameterJdbcTemplate.queryForObject("SELECT * FROM categories WHERE id = :id",
                namedParameters, BeanPropertyRowMapper.newInstance(Category.class));
        return category;
    }

    @Override
    public List<Category> findAll() {
        return namedParameterJdbcTemplate.query("SELECT * from categories", BeanPropertyRowMapper.newInstance(Category.class));
    }

    public List<Category> findAll(String page, String limit) {
        int _page = Integer.valueOf(page);
        int _limit = Integer.valueOf(limit);
        int _offset = (_page - 1)*_limit;
        SqlParameterSource namedParameter = new MapSqlParameterSource().addValue("offset", _offset).addValue("limit", _limit);
        return namedParameterJdbcTemplate.query("SELECT * from categories LIMIT :offset, :limit"
        ,namedParameter, BeanPropertyRowMapper.newInstance(Category.class));
    }

    @Override
    public int deleteById(int id) {
        SqlParameterSource namedParameter = new MapSqlParameterSource().addValue("id", id);
        return namedParameterJdbcTemplate.update("DELETE FROM categories WHERE id= :id", namedParameter);
    }

    public int deleteAllProductWithCategoryId(int id){
        SqlParameterSource namedParameter = new MapSqlParameterSource().addValue("id", id);
        return namedParameterJdbcTemplate.update("DELETE FROM products WHERE category= :id", namedParameter);
    }

//    @Override
//    public int insert(Category model) {
//        SqlParameterSource namedParameter = new BeanPropertySqlParameterSource(model);
//        return namedParameterJdbcTemplate.update("INSERT INTO categories (category_code, category_name, descript) " +
//                "VALUES (:categoryCode, :categoryName, :descript)", namedParameter);
//    }

//    @Override
//    public int update(Category model) {
//        SqlParameterSource namedParameter = new BeanPropertySqlParameterSource(model);
//        return namedParameterJdbcTemplate.update("UPDATE categories SET category_code = :categoryCode, category_name= :categoryName," +
//                        " descript= :descript WHERE id= :id", namedParameter);
//    }
}
