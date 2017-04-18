/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banking.system;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
/**
 *
 * @author Alzn-
 */
public class CustomerService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    
    public List<customer> retrieveCustomer() {
        return allEntries();
    }
    
    public List<customer> allEntries() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<customer> cq = cb.createQuery(customer.class);
        Root<customer> rootEntry = cq.from(customer.class);
        CriteriaQuery<customer> all = cq.select(rootEntry);
        TypedQuery<customer> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
    
    public customer retrieveCustomer(int id) {
        customer test = em.find(customer.class, id);
        em.close();
        return test;
    }
    
    public customer createCustomer(customer b) { 
        customer test = em.find(customer.class, b.getCustid());
        if (test == null) {
            tx.begin();
            em.persist(b);
            tx.commit();
            
            em.close();
        }

        return b;
    }
    
    public void deleteCustomer(int id) {
        customer test = em.find(customer.class, id);
        if (test !=null) {
            tx.begin();
            em.remove(test);
            tx.commit();
            
            em.close();
        }
    }
    
}
