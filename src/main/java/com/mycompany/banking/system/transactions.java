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
public class transactions implements Serializable{
    @Id
    private int trid;
    private String phonenumber;
    private String typeoft;
    private String description;
    private String date;
    private int accounts_accountid;
    private int accounts_customer_custid;

 public transactions() {
    }

    public transactions(int trid,String phonenumber, String typeoft, String description, String date, int accounts_accountid, int accounts_customer_custid) {
        this.trid = trid;
        this.phonenumber = phonenumber;
        this.typeoft = typeoft;
        this.description = description;
        this.date = date;
        this.accounts_accountid = accounts_accountid;
        this.accounts_customer_custid = accounts_customer_custid;
    }

    public void setTrid(int trid) {
        this.trid = trid;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setTypeoft(String typeoft) {
        this.typeoft = typeoft;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAccounts_accountid(int accounts_accountid) {
        this.accounts_accountid = accounts_accountid;
    }

    public void setAccounts_customer_custid(int accounts_customer_custid) {
        this.accounts_customer_custid = accounts_customer_custid;
    }

    public int getTrid() {
        return trid;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getTypeoft() {
        return typeoft;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public int getAccounts_accountid() {
        return accounts_accountid;
    }

    public int getAccounts_customer_custid() {
        return accounts_customer_custid;
    }

}
