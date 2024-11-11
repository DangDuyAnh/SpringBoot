package com.example.dataconnect.reposities;

import com.example.dataconnect.models.Kho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KhoReposity implements Reposity<Kho>{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Kho model) {
        return jdbcTemplate.update("INSERT INTO kho (makho, ten, diadiem) VALUES(?,?,?)",
                new Object[] { model.getMaKho(), model.getTen(), model.getDiaDiem() });
    }

    @Override
    public int update(Kho model) {
        return jdbcTemplate.update("UPDATE kho SET makho=?, ten=?, diadiem=? WHERE id=?",
                new Object[] { model.getMaKho(), model.getTen(), model.getDiaDiem(), model.getId() });
    }

    @Override
    public Kho findById(int id) {
        Kho kho = jdbcTemplate.queryForObject("SELECT * FROM kho WHERE id=?",
                BeanPropertyRowMapper.newInstance(Kho.class), id);

        return kho;
    }

    @Override
    public List<Kho> findAll() {
        return jdbcTemplate.query("SELECT * from kho", BeanPropertyRowMapper.newInstance(Kho.class));
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM kho WHERE id=?", id);
    }
}
