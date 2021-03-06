/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
something
 */
package com.mycompany.banking.system;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author Elian Arias
 */
@Path("/customer")
public class CustomerResources {
    
    CustomerService customerService = new CustomerService();     
    
    public CustomerResources() {
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Customer> listCustomer() {
        return customerService.retrieveCustomer();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Customer getCustomer(@PathParam("id") int id) {
        return customerService.retrieveCustomer(id);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Customer saveCustomer(Customer b) {
        return customerService.createCustomer(b);
    }
    
    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void removeCustomer(@PathParam("id") int id) {
        customerService.deleteCustomer(id);
    }
}
