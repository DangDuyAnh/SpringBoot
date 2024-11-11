package com.example.dataconnect.services;

import com.example.dataconnect.modelJPA.SanPham;
import com.example.dataconnect.models.Kho;
import com.example.dataconnect.reposities.SanPhamJPAResposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/san-pham-jpa")
public class SanPhamJPAService {
    @Autowired
    SanPhamJPAResposity sanPhamResposity;

    @GetMapping("/all")
    public ResponseEntity<List<SanPham>> findAll(){
        try {
            List<SanPham> sanPham = new ArrayList<SanPham>();
            sanPhamResposity.findAll().forEach(sanPham::add);
            return new ResponseEntity<>(sanPham, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<SanPham> create(@RequestBody SanPham sanPham){
        try {
            SanPham sp = sanPhamResposity.save(sanPham);
            return new ResponseEntity<>(sp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//Support đổi ten, masanpham
    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") int id, @RequestBody SanPham sanPham) {
        try {
            SanPham _sanPham = sanPhamResposity.findById(id).get();
            if (_sanPham != null) {
                _sanPham.setTen(sanPham.getTen());
                _sanPham.setMaSanPham(sanPham.getMaSanPham());
                return new ResponseEntity<>(sanPhamResposity.save(_sanPham), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Không tồn tại san pham có id =" + id, HttpStatus.NOT_FOUND);
            }
        } catch(Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
