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
@Path("/branch")
public class BranchResources {
    
    BranchService branchService = new BranchService();     
    
    public BranchResources() {
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Branch> listBranch() {
        return branchService.retrieveBranch();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Branch getBranch(@PathParam("id") int id) {
        return branchService.retrieveBranch(id);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Branch saveBranch(Branch b) {
        return branchService.createBranch(b);
    }
    
    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void removeBranch(@PathParam("id") int id) {
        branchService.deleteBranch(id);
    }
}
