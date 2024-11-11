package com.example.dataconnect.reposities;

import com.example.dataconnect.models.Kho;
import com.example.dataconnect.models.LoaiDanhMuc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoaiDanhMucReposity implements Reposity<LoaiDanhMuc>{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public int insert(LoaiDanhMuc model) {
        SqlParameterSource namedParameter = new BeanPropertySqlParameterSource(model);
        return namedParameterJdbcTemplate.update("INSERT INTO LoaiDanhMuc (maloaidanhmuc, ten, mota) " +
                "VALUES (:maLoaiDanhMuc, :ten, :moTa)", namedParameter);
    }

    @Override
    public int update(LoaiDanhMuc model) {
        SqlParameterSource namedParameter = new BeanPropertySqlParameterSource(model);
        return namedParameterJdbcTemplate.update("UPDATE LoaiDanhMuc SET maloaidanhmuc= :maLoaiDanhMuc, ten= :ten," +
                        " mota= :moTa WHERE id= :id", namedParameter);
    }

    @Override
    public LoaiDanhMuc findById(int id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        LoaiDanhMuc loaiDanhMuc = namedParameterJdbcTemplate.queryForObject("SELECT * FROM LoaiDanhMuc WHERE id = :id",
                namedParameters, BeanPropertyRowMapper.newInstance(LoaiDanhMuc.class));
        return loaiDanhMuc;
    }

    @Override
    public List<LoaiDanhMuc> findAll() {
        return namedParameterJdbcTemplate.query("SELECT * from LoaiDanhMuc", BeanPropertyRowMapper.newInstance(LoaiDanhMuc.class));
    }

    @Override
    public int deleteById(int id) {
        SqlParameterSource namedParameter = new MapSqlParameterSource().addValue("id", id);
        return namedParameterJdbcTemplate.update("DELETE FROM LoaiDanhMuc WHERE id= :id", namedParameter);
    }
}
