package com.example.lapweek_2.repositories;

import com.example.lapweek_2.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public ProductRepository(){
        em = Persistence
                .createEntityManagerFactory("lab_week_2")
                .createEntityManager();
        trans = em.getTransaction();
    }
    public void insert(Product product){
        try{
            trans.begin();
            em.persist(product);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }

    public void update(Product product){
        try{
            trans.begin();
            em.merge(product);
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
            em.remove(product);
            trans.commit();
            return true;
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
        return false;
    }

    public Optional<Product> findbyId(long id){
        TypedQuery<Product> query = em.createQuery("select prod from Product prod where prod.product_id = ?1", Product.class);
        query.setParameter(1, id);
        Product product = query.getSingleResult();
        return product == null ? Optional.empty(): Optional.of(product);
    }
    public List<Product> getAll(){
        return em.createQuery("select prod from Product prod", Product.class).getResultList();
    }
}
