package com.example.lapweek_2.repositories;


import com.example.lapweek_2.models.Order;
import com.example.lapweek_2.models.Order_detail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class OrderDetailRepository {
    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public OrderDetailRepository(){
        em = Persistence
                .createEntityManagerFactory("lab_week_2")
                .createEntityManager();
        trans = em.getTransaction();
    }
    public void insert(Order_detail orderDetail){
        try{
            trans.begin();
            em.persist(orderDetail);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }

    public void update(Order_detail orderDetail){
        try{
            trans.begin();
            em.merge(orderDetail);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }
    public boolean delete(long id){
        try{
            trans.begin();
            Order order = em.find(Order.class, id);
            em.remove(order.getOrderDetail());
            trans.commit();
            return true;
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
        return false;
    }
}
