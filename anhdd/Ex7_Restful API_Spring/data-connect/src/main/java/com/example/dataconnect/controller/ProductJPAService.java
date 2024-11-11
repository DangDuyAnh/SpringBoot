package com.example.dataconnect.controller;

import com.example.dataconnect.modelJPA.Product;
import com.example.dataconnect.repositories.ProductJPARespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin/products")
public class ProductJPAService {
    @Autowired
    ProductJPARespository productJPARespository;

    @GetMapping("")
    public ResponseEntity<List<Product>> findAll(@RequestParam(required = false) String page, @RequestParam(required = false) String limit){
        try {
            List<Product> productList = new ArrayList<Product>();
            productJPARespository.findAll().forEach(productList::add);
        if (page == null)
            productJPARespository.findAll().forEach(productList::add);
        else if (page != null && limit != null) {
            int _page = Integer.valueOf(page);
            int _limit = Integer.valueOf(limit);
            int _offset = (_page - 1)*_limit;
            productList = productJPARespository.findAllWithLimit(PageRequest.of(_offset, _limit));
        }
        else return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        System.out.println(productList);
        return new ResponseEntity<>(productList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") int id){
        try{
            Product product = productJPARespository.findById(id).get();
            System.out.println(product);
            return new ResponseEntity<>(product, HttpStatus.OK);
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
    public ResponseEntity<Product> create(@Valid @RequestBody Product product){
        try {
            Product sp = productJPARespository.save(product);
            return new ResponseEntity<>(sp, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//Support đổi ten, masanpham
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") int id, @RequestBody Product product) {
        try {
            Product _sanPham = productJPARespository.findById(id).get();
            _sanPham.setProductName(product.getProductName());
            _sanPham.setProductCode(product.getProductCode());
            return new ResponseEntity<>(productJPARespository.save(_sanPham), HttpStatus.OK);
        } catch(EmptyResultDataAccessException exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch(Exception e) {
            System.out.println(e);
            return new ResponseEntity<>("Sản phẩm ko hợp lệ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") int id) {
        try {
            productJPARespository.deleteById(id);
            return new ResponseEntity<>("Xóa danh mục thành công.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Lỗi.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/top-sell")
    public  ResponseEntity<List<Product>> findAllTopSell(@RequestParam int k){
        try {
            return new ResponseEntity<>(productJPARespository.findAllTopSell(k), HttpStatus.OK);
        } catch(EmptyResultDataAccessException exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch(Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
