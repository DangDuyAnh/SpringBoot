package com.example.dataconnect.services;

import com.example.dataconnect.models.LoaiDanhMuc;
import com.example.dataconnect.reposities.LoaiDanhMucReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/loai-danh-muc")
public class LoaiDanhMucService {
    @Autowired
    LoaiDanhMucReposity loaiDanhMucReposity;

    @GetMapping("/all")
    public ResponseEntity<List<LoaiDanhMuc>> findAll(){
        try {
            List<LoaiDanhMuc> loaiDanhMuc = new ArrayList<LoaiDanhMuc>();
            loaiDanhMuc = loaiDanhMucReposity.findAll();
            System.out.println(loaiDanhMuc);
            return new ResponseEntity<>(loaiDanhMuc, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/single/{id}")
    public ResponseEntity<LoaiDanhMuc> findById(@PathVariable("id") int id){
        try{
            LoaiDanhMuc loaiDanhMuc = loaiDanhMucReposity.findById(id);
            System.out.println(loaiDanhMuc);
            return new ResponseEntity<>(loaiDanhMuc, HttpStatus.OK);
        }
        catch(EmptyResultDataAccessException exception){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody LoaiDanhMuc loaiDanhMuc){
        try{
            loaiDanhMucReposity.insert(new LoaiDanhMuc(loaiDanhMuc.getMaLoaiDanhMuc(), loaiDanhMuc.getTen(), loaiDanhMuc.getMoTa()));
            return new ResponseEntity<>("Danh mục được tạo thanh cong.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> updateLoaiDanhMuc(@PathVariable("id") int id, @RequestBody LoaiDanhMuc loaiDanhMuc) {
        try {
            LoaiDanhMuc _loaiDanhMuc = loaiDanhMucReposity.findById(id);
            _loaiDanhMuc.setTen(loaiDanhMuc.getTen());
            _loaiDanhMuc.setMaLoaiDanhMuc(loaiDanhMuc.getMaLoaiDanhMuc());
            _loaiDanhMuc.setMoTa(loaiDanhMuc.getMoTa());
            loaiDanhMucReposity.update(_loaiDanhMuc);
            return new ResponseEntity<>("Sửa loại danh mục thành công.", HttpStatus.OK);
        }
        catch(EmptyResultDataAccessException exception){
            return new ResponseEntity<>("Id không tồn tại",HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>("Lỗi.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteKho(@PathVariable("id") int id) {
        try {
            int result = loaiDanhMucReposity.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Không tồn tại Danh mục có id=" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("Xóa danh mục thành công.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Lỗi.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
