package com.example.dataconnect.repositories;

import com.example.dataconnect.models.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.util.List;

@org.springframework.stereotype.Repository
public class StoreRepository implements Repository<Store> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StoreRepository (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Store insert(Store model) {
        String sql = "INSERT INTO stores (store_code, store_name, address) VALUES(?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
            ps.setString(1, model.getStoreCode());
            ps.setString(2, model.getStoreName());
            ps.setString(3, model.getAddress());
            return ps;
        }, keyHolder);

        Store _store = jdbcTemplate.queryForObject("SELECT * FROM stores WHERE id=?",
                BeanPropertyRowMapper.newInstance(Store.class), keyHolder.getKey());
        return _store;
    }

    @Override
    public Store update(Store model) {
        jdbcTemplate.update("UPDATE stores SET store_code=?, store_name=?, address=? WHERE id=?",
                new Object[] { model.getStoreCode(), model.getStoreName(), model.getAddress(), model.getId() });
        Store _store = jdbcTemplate.queryForObject("SELECT * FROM stores WHERE id=?",
                BeanPropertyRowMapper.newInstance(Store.class), model.getId());
        return _store;
    }

    @Override
    public Store findById(int id) {
        Store store = jdbcTemplate.queryForObject("SELECT * FROM stores WHERE id=?",
                BeanPropertyRowMapper.newInstance(Store.class), id);

        return store;
    }

    @Override
    public List<Store> findAll() {
        return jdbcTemplate.query("SELECT * from stores", BeanPropertyRowMapper.newInstance(Store.class));
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM stores WHERE id=?", id);
    }

//    @Override
//    public int insert(Store model) {
//        return jdbcTemplate.update("INSERT INTO stores (store_code, store_name, address) VALUES(?,?,?)",
//                new Object[] { model.getStoreCode(), model.getStoreName(), model.getAddress() });
//    }

//    @Override
//    public int update(Store model) {
//        return jdbcTemplate.update("UPDATE stores SET store_code=?, store_name=?, address=? WHERE id=?",
//                new Object[] { model.getStoreCode(), model.getStoreName(), model.getAddress(), model.getId() });
//    }
}
