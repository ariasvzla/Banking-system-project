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
@Path("/accounts")
public class AccountsResources {
    
    AccountsService accountsService = new AccountsService();     
    
    public AccountsResources() {
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<accounts> listAccounts() {
        return accountsService.retrieveAccounts();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public accounts getAccounts(@PathParam("id") int id) {
        return accountsService.retrieveAccounts(id);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public accounts saveAccounts(accounts b) {
        return accountsService.createAccounts(b);
    }
    
    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void removeAccounts(@PathParam("id") int id) {
        accountsService.deleteAccounts(id);
    }
}
