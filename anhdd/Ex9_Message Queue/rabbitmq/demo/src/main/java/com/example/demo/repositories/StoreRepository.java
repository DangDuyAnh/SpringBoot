package com.example.demo.repositories;

import com.example.demo.models.ProductsInStores;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<ProductsInStores, Long> {
}
