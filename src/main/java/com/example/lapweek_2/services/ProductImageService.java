package com.example.lapweek_2.services;

import com.example.lapweek_2.models.Product_image;
import com.example.lapweek_2.repositories.ProductImageRepository;

public class ProductImageService {
    private ProductImageRepository repository;
    public ProductImageService(){
        this.repository = new ProductImageRepository();
    }
    public void insert(Product_image productImage){
        repository.insert(productImage);
    }
    public void update(Product_image productImage){
        repository.update(productImage);
    }
    public boolean delete(long id){
        return repository.delete(id);
    }
}
