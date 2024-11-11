package com.example.demo.services;

import com.example.demo.dto.ProductInStoresdto;
import com.example.demo.models.ProductsInStores;
import com.example.demo.repositories.ProductsInStoresRepo;
import com.example.demo.repositories.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsInStoresService {
    ProductsInStoresRepo productsInStoresRepo;
    StoreRepository storeRepository;

    public ProductsInStoresService(ProductsInStoresRepo productsInStoresRepo, StoreRepository storeRepository) {
        this.productsInStoresRepo = productsInStoresRepo;
        this.storeRepository = storeRepository;
    }

    public List<ProductInStoresdto> findAll(){

        try{
            List<ProductInStoresdto> storesList = new ArrayList<ProductInStoresdto>();
            productsInStoresRepo.findAllStore().forEach(storesList::add);
            return  storesList;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<ProductsInStores> save(List<ProductInStoresdto> storesList){
        try{
            List<ProductsInStores> saveStore = new ArrayList<ProductsInStores>();
            for (ProductInStoresdto storesdto: storesList) {
                saveStore.add(new ProductsInStores(storesdto.getStore(), storesdto.getProductNum(), storesdto.getCreatedDate()));
            }
            storeRepository.saveAll(saveStore);
            return saveStore;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
