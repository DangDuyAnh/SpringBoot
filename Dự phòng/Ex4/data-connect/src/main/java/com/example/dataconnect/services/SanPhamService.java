package com.example.dataconnect.services;

import com.example.dataconnect.models.LoaiDanhMuc;
import com.example.dataconnect.models.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@RequestMapping("/api/san-pham")
public class SanPhamService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    private void setSimpleJdbcInsert(JdbcTemplate jdbcTemplate) {
        simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("sanpham");
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody SanPham sanpham){
        try{
            SqlParameterSource parameters = new BeanPropertySqlParameterSource(sanpham);
            simpleJdbcInsert.execute(parameters);
            return new ResponseEntity<>("San pham duoc tao thanh cong.", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
