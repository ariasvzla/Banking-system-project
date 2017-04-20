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
    
    public List<Branch> retrieveBranch() {
        return allEntries();
    }
    
    public List<Branch> allEntries() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Branch> cq = cb.createQuery(Branch.class);
        Root<Branch> rootEntry = cq.from(Branch.class);
        CriteriaQuery<Branch> all = cq.select(rootEntry);
        TypedQuery<Branch> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }
    
    public Branch retrieveBranch(int id) {
        Branch test = em.find(Branch.class, id);
        em.close();
        return test;
    }
    
    public Branch createBranch(Branch b) { 
        Branch test = em.find(Branch.class, b.getBranchid());
        if (test == null) {
            tx.begin();
            em.persist(b);
            tx.commit();
            
            em.close();
        }

        return b;
    }
    
    public void deleteBranch(int id) {
        Branch test = em.find(Branch.class, id);
        if (test !=null) {
            tx.begin();
            em.remove(test);
            tx.commit();
            
            em.close();
        }
    }
    
}
