package com.example.dataconnect.repositories;

import com.example.dataconnect.modelJPA.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductJPARespository extends CrudRepository<Product, Integer> {

    @Query("SELECT p from Product p")
    public List<Product> findAllWithLimit(Pageable pageable);

    @Query(value = "CALL getTopSell(:k);", nativeQuery = true)
    public List<Product> findAllTopSell(@Param("k") Integer k);
}
