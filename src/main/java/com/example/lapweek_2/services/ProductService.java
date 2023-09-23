package com.example.lapweek_2.services;

import com.example.lapweek_2.models.Product;
import com.example.lapweek_2.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private ProductRepository repository;
    public ProductService(){
        this.repository = new ProductRepository();
    }
    public void insert(Product product){
        repository.insert(product);
    }
    public void update(Product product){
        repository.update(product);
    }
    public void delete(Product product){
        repository.delete(product);
    }
    public Optional<Product> findById(long id){
        return repository.findbyId(id);
    }
    public List<Product> getAll(){
        return repository.getAll();
    }
}
