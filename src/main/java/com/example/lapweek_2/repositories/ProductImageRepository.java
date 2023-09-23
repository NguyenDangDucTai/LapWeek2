package com.example.lapweek_2.repositories;

import com.example.lapweek_2.models.Product_image;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductImageRepository {
    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public ProductImageRepository(){
        em = Persistence
                .createEntityManagerFactory("lab_week_2")
                .createEntityManager();
        trans = em.getTransaction();
    }
    public void insert(Product_image productImageImage){
        try{
            trans.begin();
            em.persist(productImageImage);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }

    public void update(Product_image productImageImage){
        try{
            trans.begin();
            em.merge(productImageImage);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }
    public void delete(Product_image productImageImage){
        try{
            trans.begin();
            em.remove(productImageImage);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }
}
