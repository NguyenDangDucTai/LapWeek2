package com.example.lapweek_2.repositories;

import com.example.lapweek_2.models.Product;
import com.example.lapweek_2.models.Product_price;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductPriceRepository {
    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public ProductPriceRepository(){
        em = Persistence
                .createEntityManagerFactory("lab_week_2")
                .createEntityManager();
        trans = em.getTransaction();
    }
    public void insert(Product_price productPrice){
        try{
            trans.begin();
            em.persist(productPrice);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }

    public void update(Product_price productPrice){
        try{
            trans.begin();
            em.merge(productPrice);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }
    public boolean delete(long id){
        try{
            trans.begin();
            Product product = em.find(Product.class, id);
            em.remove(product.getProductPrice());
            trans.commit();
            return true;
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
        return false;
    }

}
