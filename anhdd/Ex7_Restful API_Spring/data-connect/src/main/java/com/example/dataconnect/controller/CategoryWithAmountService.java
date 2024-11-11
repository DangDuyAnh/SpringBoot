package com.example.dataconnect.controller;

import com.example.dataconnect.dto.CategoryWithAmountDto;
import com.example.dataconnect.repositories.CategoryWithAmountJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin/category-with-amount")
public class CategoryWithAmountService {
    @Autowired
    CategoryWithAmountJPARepository categoryWithAmountJPARepository;

    @GetMapping("")
    public ResponseEntity<List<CategoryWithAmountDto>> find(){
    try {
        List<CategoryWithAmountDto> categories = new ArrayList<CategoryWithAmountDto>();
        categoryWithAmountJPARepository.findCategoryWithAmount().forEach(categories::add);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    } catch (Exception e) {
        System.out.println(e);
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
}
