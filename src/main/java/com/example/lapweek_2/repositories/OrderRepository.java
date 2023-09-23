package com.example.lapweek_2.repositories;

import com.example.lapweek_2.models.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.List;

public class OrderRepository {
    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public OrderRepository(){
        em = Persistence
                .createEntityManagerFactory("lab_week_2")
                .createEntityManager();
        trans = em.getTransaction();
    }
    public void insert(Order order){
        try{
            trans.begin();
            em.persist(order);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }

    public void update(Order order){
        try{
            trans.begin();
            em.merge(order);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }
    public void delete(Order order){
        try{
            trans.begin();
            em.remove(order);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }
    public List<Order> findbyDate(Date date){
        return em.createQuery("select o from Order o where o.orderDate = ?1")
                .setParameter(1, Order.class)
                .getResultList();
    }
}
