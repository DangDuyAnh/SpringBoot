package com.example.dataconnect.services;

import com.example.dataconnect.dto.ProductWithCategory;
import com.example.dataconnect.dto.ProductWithCategoryBody;
import com.example.dataconnect.repositories.ProductWithCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/product-with-category")
public class ProductWithCategoryService {
    @Autowired
    ProductWithCategoryRepository productWithCategoryRepository;

    @PostMapping("")
    public ResponseEntity<List<ProductWithCategory>> findWithProductNameAndCategory(@RequestBody ProductWithCategoryBody body){
        try {
            List<ProductWithCategory> products;
            products = productWithCategoryRepository.findWithProductNameAndCategory(body.getCategoryName(), "%" + body.getProductName() + "%");
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<ProductWithCategory>> findWithProductNameAndCategory(){
        try {
            List<ProductWithCategory> products;
            products = productWithCategoryRepository.findWithProductNameAndCategory();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
