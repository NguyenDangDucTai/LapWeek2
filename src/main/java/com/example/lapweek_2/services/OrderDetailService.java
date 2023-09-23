package com.example.lapweek_2.services;

import com.example.lapweek_2.models.Order_detail;
import com.example.lapweek_2.repositories.OrderDetailRepository;

import java.util.List;
import java.util.Optional;

public class OrderDetailService {
    private OrderDetailRepository repository;
    public OrderDetailService(){
        this.repository = new OrderDetailRepository();
    }
    public void insert(Order_detail orderDetail){
        repository.insert(orderDetail);
    }
    public void update(Order_detail orderDetail){
        repository.update(orderDetail);
    }
    public boolean delete(long id){
        return repository.delete(id);
    }
}
