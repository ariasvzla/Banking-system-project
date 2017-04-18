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
public class TransactionsService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("transactions");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    
    public List<transactions> retrieveTransactions() {
        return allEntries();
    }
    
    public List<transactions> allEntries() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<transactions> cq = cb.createQuery(transactions.class);
        Root<transactions> rootEntry = cq.from(transactions.class);
        CriteriaQuery<transactions> all = cq.select(rootEntry);
        TypedQuery<transactions> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
    
    public transactions retrieveTransactions(int id) {
        transactions test = em.find(transactions.class, id);
        em.close();
        return test;
    }
    
    public transactions createTransactions(transactions b) { 
        transactions test = em.find(transactions.class, b.getTrid());
        if (test == null) {
            tx.begin();
            em.persist(b);
            tx.commit();
            
            em.close();
        }

        return b;
    }
    
    public void deleteTransactions(int id) {
        transactions test = em.find(transactions.class, id);
        if (test !=null) {
            tx.begin();
            em.remove(test);
            tx.commit();
            
            em.close();
        }
    }
    
}
