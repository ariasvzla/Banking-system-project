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
public class customer implements Serializable{
    @Id
    private int custid;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String password;
    

 public customer() {
    }

    public customer(int custid, String firstname, String address, String email, String password) {
        this.custid = custid;
        this.firstname = firstname;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCustid() {
        return custid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
}
