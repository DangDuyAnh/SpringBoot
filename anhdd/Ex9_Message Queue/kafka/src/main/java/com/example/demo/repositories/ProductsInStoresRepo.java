package com.example.demo.repositories;

import com.example.demo.dto.ProductInStoresdto;
import com.example.demo.models.ProductsInStores;
import com.example.demo.models.ProductsInStoresMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductsInStoresRepo extends CrudRepository<ProductsInStoresMapper, Long> {
    @Query(name = "products_in_stores", nativeQuery = true)
    List<ProductInStoresdto> findAllStore();
}
