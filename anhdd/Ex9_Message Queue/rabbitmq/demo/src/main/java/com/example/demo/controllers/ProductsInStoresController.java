package com.example.demo.controllers;

import com.example.demo.dto.ProductInStoresdto;
import com.example.demo.models.ProductsInStores;
import com.example.demo.services.ProductsInStoresService;
import com.example.demo.services.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/products-in-stores")
public class ProductsInStoresController {

    @Autowired
    ProductsInStoresService productsInStoresService;

    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping("")
    public ResponseEntity<List<ProductsInStores>> findAll(){
        try {
            List<ProductInStoresdto> storesList = productsInStoresService.findAll();
            List<ProductsInStores> stores = productsInStoresService.save(storesList);
            rabbitMQSender.send(stores);
            return new ResponseEntity<>(stores, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
