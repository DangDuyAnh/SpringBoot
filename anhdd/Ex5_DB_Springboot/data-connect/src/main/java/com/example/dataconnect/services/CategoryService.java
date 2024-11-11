package com.example.dataconnect.services;

import com.example.dataconnect.models.Category;
import com.example.dataconnect.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin/categories")
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("")
    public ResponseEntity<List<Category>> findAll(@RequestParam(required = false) String page, @RequestParam(required = false) String limit){
        try {
            List<Category> categoryList = new ArrayList<Category>();
            if (page == null)
                categoryList = categoryRepository.findAll();
            else if (page != null && limit != null)
                categoryList = categoryRepository.findAll(page, limit);
            else return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            System.out.println(categoryList);
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable("id") int id){
        try{
            Category category = categoryRepository.findById(id);
            System.out.println(category);
            return new ResponseEntity<>(category, HttpStatus.OK);
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
    public ResponseEntity<Category> create(@RequestBody Category category){
        try{
            Category _category = categoryRepository.insert(new Category(category.getCategoryCode(), category.getCategoryName(), category.getDescript()));
            return new ResponseEntity<>(_category, HttpStatus.CREATED);
        }
        catch(EmptyResultDataAccessException exception){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") int id, @RequestBody Category category) {
        try {
            Category _category = categoryRepository.findById(id);
            _category.setCategoryName(category.getCategoryName());
            _category.setCategoryCode(category.getCategoryCode());
            _category.setDescript(category.getDescript());
            Category rsCategory = categoryRepository.update(_category);
            return new ResponseEntity<>( rsCategory, HttpStatus.OK);
        }
            catch(EmptyResultDataAccessException exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") int id) {
        try {
            int result = categoryRepository.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Không tồn tại Danh mục có id=" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("Xóa danh mục thành công.", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>("Lỗi.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteWithMappingProducts/{id}")
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public ResponseEntity<String> deleteCategoryWithProducts(@PathVariable("id") int id) {
        try {
            categoryRepository.deleteAllProductWithCategoryId(id);
            int result = categoryRepository.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Không tồn tại Danh mục có id=" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("Xóa danh mục thành công.", HttpStatus.OK);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println(e);
            return new ResponseEntity<>("Lỗi.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
