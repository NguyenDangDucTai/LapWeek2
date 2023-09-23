package com.example.lapweek_2.repositories;

import com.example.lapweek_2.models.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public CustomerRepository(){
        em = Persistence
                .createEntityManagerFactory("lab_week_2")
                .createEntityManager();
        trans = em.getTransaction();
    }
    public void insert(Customer customer){
        try{
            trans.begin();
            em.persist(customer);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }

    public void update(Customer customer){
        try{
            trans.begin();
            em.merge(customer);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }
    public void delete(Customer customer){
        try{
            trans.begin();
            em.remove(customer);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }
    public Optional<Customer> findbyId(long id){
        TypedQuery<Customer> query = em.createNamedQuery("Customers.findbyId", Customer.class);
        query.setParameter(1, id);
        Customer emp = query.getSingleResult();
        return emp == null ? Optional.empty(): Optional.of(emp);
    }
    public List<Customer> getAll(){
        return em.createQuery("select cus from Customer cus", Customer.class).getResultList();
    }
}
