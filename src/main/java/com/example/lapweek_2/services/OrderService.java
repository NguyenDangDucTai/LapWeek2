package com.example.lapweek_2.services;

import com.example.lapweek_2.models.Order;
import com.example.lapweek_2.repositories.OrderRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class OrderService {
    private OrderRepository repository;
    public OrderService(){
        this.repository = new OrderRepository();
    }
    public void insert(Order order){
        repository.insert(order);
    }
    public void update(Order order){
        repository.update(order);
    }
    public void delete(Order order){
        repository.delete(order);
    }
    public List<Order> findByDate(Date date){
        return repository.findbyDate(date);
    }

}
