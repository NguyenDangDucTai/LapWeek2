package com.example.lapweek_2.services;

import com.example.lapweek_2.models.Product_price;
import com.example.lapweek_2.repositories.ProductPriceRepository;

public class ProductPriceService {
    private ProductPriceRepository repository;
    public ProductPriceService(){
        this.repository = new ProductPriceRepository();
    }
    public void insert(Product_price productPrice){
        repository.insert(productPrice);
    }
    public void update(Product_price productPrice){
        repository.update(productPrice);
    }
    public void delete(Product_price productPrice){
        repository.delete(productPrice);
    }
}
