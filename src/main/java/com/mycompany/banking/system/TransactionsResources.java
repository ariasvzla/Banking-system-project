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
@Path("/transactions")
public class TransactionsResources {
    
    TransactionsService transactionsService = new TransactionsService();     
    
    public TransactionsResources() {
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<transactions> listTransactions() {
        return transactionsService.retrieveTransactions();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public transactions getTransactions(@PathParam("id") int id) {
        return transactionsService.retrieveTransactions(id);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public transactions saveTransactions(transactions b) {
        return transactionsService.createTransactions(b);
    }
    
    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void removeTransactions(@PathParam("id") int id) {
        transactionsService.deleteTransactions(id);
    }
}
