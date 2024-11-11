package com.example.demo.controllers;

import com.example.demo.dto.ProductInStoresdto;
import com.example.demo.kafka.Message;
import com.example.demo.models.ProductsInStores;
import com.example.demo.services.ProductsInStoresService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/admin/products-in-stores")
public class ProductsInStoresController {

    ProductsInStoresService productsInStoresService;

    private final KafkaTemplate<String, Message> kafkaTemplate;

    public ProductsInStoresController(ProductsInStoresService productsInStoresService, KafkaTemplate<String, Message> kafkaTemplate){
        this.productsInStoresService = productsInStoresService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("")
    public ResponseEntity<List<ProductsInStores>> findAll(){
        try {
            Message message = new Message("Thong ke kho voi so luong san pham", LocalDateTime.now());
            System.out.println("message " + message);
            kafkaTemplate.send("topic1", message);
            List<ProductInStoresdto> storesList = productsInStoresService.findAll();
            List<ProductsInStores> stores = productsInStoresService.save(storesList);
            return new ResponseEntity<>(stores, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
