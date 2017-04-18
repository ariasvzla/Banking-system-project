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
public class BranchService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("branch");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
    
    public List<branch> retrieveBranch() {
        return allEntries();
    }
    
    public List<branch> allEntries() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<branch> cq = cb.createQuery(branch.class);
        Root<branch> rootEntry = cq.from(branch.class);
        CriteriaQuery<branch> all = cq.select(rootEntry);
        TypedQuery<branch> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
    
    public branch retrieveBranch(int id) {
        branch test = em.find(branch.class, id);
        em.close();
        return test;
    }
    
    public branch createBranch(branch b) { 
        branch test = em.find(branch.class, b.getBranchid());
        if (test == null) {
            tx.begin();
            em.persist(b);
            tx.commit();
            
            em.close();
        }

        return b;
    }
    
    public void deleteBranch(int id) {
        branch test = em.find(branch.class, id);
        if (test !=null) {
            tx.begin();
            em.remove(test);
            tx.commit();
            
            em.close();
        }
    }
    
}
