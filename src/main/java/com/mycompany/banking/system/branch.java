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
public class branch implements Serializable{
    @Id
    private int branchid;
    private String phonenumber;
    private int accounts_accountid;
    private int accounts_customer_custid;
    

 public branch() {
    }

    public branch(int branchid, String phonenumber, int accounts_accountid, int accounts_customer_custid) {
        this.branchid = branchid;
        this.phonenumber = phonenumber;
        this.accounts_accountid = accounts_accountid;
        this.accounts_customer_custid = accounts_customer_custid;
    }

    public void setBranchid(int branchid) {
        this.branchid = branchid;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setAccounts_accountid(int accounts_accountid) {
        this.accounts_accountid = accounts_accountid;
    }

    public void setAccounts_customer_custid(int accounts_customer_custid) {
        this.accounts_customer_custid = accounts_customer_custid;
    }

    public int getBranchid() {
        return branchid;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public int getAccounts_accountid() {
        return accounts_accountid;
    }

    public int getAccounts_customer_custid() {
        return accounts_customer_custid;
    }

}
