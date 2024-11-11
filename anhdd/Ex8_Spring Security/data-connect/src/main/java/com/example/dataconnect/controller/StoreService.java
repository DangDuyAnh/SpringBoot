package com.example.dataconnect.controller;

import com.example.dataconnect.models.Store;
import com.example.dataconnect.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/admin/stores")
public class StoreService {
    @Autowired
    StoreRepository storeRepository;

    @GetMapping("")
    public ResponseEntity<List<Store>> findAll(){
        try {
            List<Store> store = new ArrayList<Store>();
//            khoReposity.findAll().forEach(kho::add);
            store = storeRepository.findAll();
            System.out.println(store);
            return new ResponseEntity<>(store, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> findById(@PathVariable("id") int id){
        try{
            Store store = storeRepository.findById(id);
            System.out.println(store);
            return new ResponseEntity<>(store, HttpStatus.OK);
        }
        catch(EmptyResultDataAccessException exception){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Store> create(@RequestBody Store store){
        try {
            Store _store = storeRepository.insert(new Store(store.getStoreCode(), store.getStoreName(), store.getAddress()));
            return new ResponseEntity<>(_store, HttpStatus.CREATED);
        }
        catch(EmptyResultDataAccessException exception){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Store> updateStore(@PathVariable("id") int id, @RequestBody Store store) {
        try {
            Store _store = storeRepository.findById(id);
            _store.setStoreName(store.getStoreName());
            _store.setAddress(store.getAddress());
            _store.setStoreCode(store.getStoreCode());
            Store rsStore = storeRepository.update(_store);
            System.out.println("hey");
            return new ResponseEntity<>(rsStore, HttpStatus.OK);
        }
        catch(EmptyResultDataAccessException exception){
            System.out.println(exception);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStore(@PathVariable("id") int id) {
        try {
            int result = storeRepository.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Không tồn tại kho có id=" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("Xóa kho thành công.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Lỗi.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
