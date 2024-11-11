package com.example.dataconnect.services;

import com.example.dataconnect.models.Kho;
import com.example.dataconnect.reposities.KhoReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/kho")
public class KhoService {
    @Autowired
    KhoReposity khoReposity;

    @GetMapping("/all")
    public ResponseEntity<List<Kho>> findAll(){
        try {
            List<Kho> kho = new ArrayList<Kho>();
//            khoReposity.findAll().forEach(kho::add);
            kho = khoReposity.findAll();
            System.out.println(kho);
            return new ResponseEntity<>(kho, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/single/{id}")
    public ResponseEntity<Kho> findById(@PathVariable("id") int id){
        try{
            Kho kho = khoReposity.findById(id);
            System.out.println(kho);
            return new ResponseEntity<>(kho, HttpStatus.OK);
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
    public ResponseEntity<String> create(@RequestBody Kho kho){
        try{
            khoReposity.insert(new Kho(kho.getMaKho(), kho.getTen(), kho.getDiaDiem()));
            return new ResponseEntity<>("Kho duoc tao thanh cong.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> updateKho(@PathVariable("id") int id, @RequestBody Kho kho) {
        try {
            Kho _kho = khoReposity.findById(id);
            if (_kho != null) {
                _kho.setTen(kho.getTen());
                _kho.setDiaDiem(kho.getDiaDiem());
                _kho.setMaKho(kho.getMaKho());
                khoReposity.update(_kho);
                return new ResponseEntity<>("Sửa kho thành công.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Không tồn tại kho có id =" + id, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>("Lỗi.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
         }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteKho(@PathVariable("id") int id) {
        try {
            int result = khoReposity.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Không tồn tại kho có id=" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("Xóa kho thành công.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Lỗi.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
