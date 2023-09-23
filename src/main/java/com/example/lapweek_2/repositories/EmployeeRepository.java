package com.example.lapweek_2.repositories;

import com.example.lapweek_2.enums.EmployeeStatus;
import com.example.lapweek_2.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;


public class EmployeeRepository {
    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public EmployeeRepository(){
        em = Persistence
                .createEntityManagerFactory("lab_week_2")
                .createEntityManager();
        trans = em.getTransaction();
    }
    public void insertEmp(Employee employee){
        try{
            trans.begin();
            em.persist(employee);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }

    public void setStatus(Employee employee, EmployeeStatus status){
        employee.setStatus(status);
    }
    public void update(Employee employee){
        try{
            trans.begin();
            em.merge(employee);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }
    public Optional<Employee> findbyId(long id){
        TypedQuery<Employee> query = em.createNamedQuery("Employee.findbyId", Employee.class);
        query.setParameter(1, id);
        Employee emp = query.getSingleResult();
        return emp == null ? Optional.empty(): Optional.of(emp);
    }
    public List<Employee> getAllEmp(){
        return em.createNamedQuery("Employee.findAll", Employee.class)
                .setParameter(1, EmployeeStatus.ACTIVE)
                .getResultList();
    }
}
