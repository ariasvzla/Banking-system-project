/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banking.system;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alzn-
 */

@Entity
@Table
@XmlRootElement
public class accounts implements Serializable{
    @Id
    private int accountid;
    private String accountnumber;
    private double balance;
    private int sortcode;
    private int customer_custid;
    private int branch_branchid;

 public accounts() {
    }

    public accounts(int accountid, String accountnumber, double balance, int sortcode, int customer_custid, int branch_branchid) {
        this.accountid = accountid;
        this.accountnumber = accountnumber;
        this.balance = balance;
        this.sortcode = sortcode;
        this.customer_custid = customer_custid;
        this.branch_branchid = branch_branchid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setSortcode(int sortcode) {
        this.sortcode = sortcode;
    }

    public void setCustomer_custid(int customer_custid) {
        this.customer_custid = customer_custid;
    }

    public void setBranch_branchid(int branch_branchid) {
        this.branch_branchid = branch_branchid;
    }

    public int getAccountid() {
        return accountid;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public double getBalance() {
        return balance;
    }

    public int getSortcode() {
        return sortcode;
    }

    public int getCustomer_custid() {
        return customer_custid;
    }

    public int getBranch_branchid() {
        return branch_branchid;
    }
    
    
}
