package com.example.lapweek_2.services;

import com.example.lapweek_2.models.Customer;
import com.example.lapweek_2.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private CustomerRepository repository;
    public CustomerService(){
        this.repository = new CustomerRepository();
    }
    public void insert(Customer customer){
        repository.insert(customer);
    }
    public void update(Customer customer){
        repository.update(customer);
    }
    public void delete(Customer customer){
        repository.delete(customer);
    }
    public Optional<Customer> findbyId(long id){
        return repository.findbyId(id);
    }
    public List<Customer> getAll(){
        return repository.getAll();
    }
}
