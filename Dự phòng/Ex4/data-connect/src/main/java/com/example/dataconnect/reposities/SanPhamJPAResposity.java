package com.example.dataconnect.reposities;

import com.example.dataconnect.modelJPA.SanPham;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SanPhamJPAResposity extends CrudRepository<SanPham, Integer> {

//    @Query("SELECT ten from SanPham")
//    public List<SanPham> findAll();
}
