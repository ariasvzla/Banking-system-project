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
    
    public List<Transactions> retrieveTransactions() {
        return allEntries();
    }
    
    public List<Transactions> allEntries() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Transactions> cq = cb.createQuery(Transactions.class);
        Root<Transactions> rootEntry = cq.from(Transactions.class);
        CriteriaQuery<Transactions> all = cq.select(rootEntry);
        TypedQuery<Transactions> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
    
    public Transactions retrieveTransactions(int id) {
        Transactions test = em.find(Transactions.class, id);
        em.close();
        return test;
    }
    
    public Transactions createTransactions(Transactions b) { 
        Transactions test = em.find(Transactions.class, b.getTrid());
        if (test == null) {
            tx.begin();
            em.persist(b);
            tx.commit();
            
            em.close();
        }

        return b;
    }
    
    public void deleteTransactions(int id) {
        Transactions test = em.find(Transactions.class, id);
        if (test !=null) {
            tx.begin();
            em.remove(test);
            tx.commit();
            
            em.close();
        }
    }
    
}
