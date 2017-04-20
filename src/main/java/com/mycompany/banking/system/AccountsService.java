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
public class AccountsService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("accounts");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    
    public List<Accounts> retrieveAccounts() {
        return allEntries();
    }
    
    public List<Accounts> allEntries() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Accounts> cq = cb.createQuery(Accounts.class);
        Root<Accounts> rootEntry = cq.from(Accounts.class);
        CriteriaQuery<Accounts> all = cq.select(rootEntry);
        TypedQuery<Accounts> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
    
    public Accounts retrieveAccounts(int id) {
        Accounts test = em.find(Accounts.class, id);
        em.close();
        return test;
    }
    
    public Accounts createAccounts(Accounts b) { 
        Accounts test = em.find(Accounts.class, b.getAccountid());
        if (test == null) {
            tx.begin();
            em.persist(b);
            tx.commit();
            
            em.close();
        }

        return b;
    }
    
    public void deleteAccounts(int id) {
        Accounts test = em.find(Accounts.class, id);
        if (test !=null) {
            tx.begin();
            em.remove(test);
            tx.commit();
            
            em.close();
        }
    }
    
}
