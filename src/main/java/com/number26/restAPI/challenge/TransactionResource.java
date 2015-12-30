package com.number26.restAPI.challenge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/transactionservice")
public class TransactionResource {
    private static final Map<Long, Transaction> transactions = new HashMap<Long, Transaction>();

    @GET
    @Path("/transaction/{transaction_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction getTransaction(@PathParam("transaction_id") long transaction_id) {
        Transaction transaction = transactions.get(transaction_id);
    	if (transaction == null) {
    		throw new WebApplicationException(Response.Status.NOT_FOUND);
    	}
        return transaction;
    }

    @PUT
    @Path("/transaction/{transaction_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTransaction(@PathParam("transaction_id") long transaction_id, Transaction transaction) {
    	transactions.put(transaction_id,transaction);
        return Response.status(200).build();
    }

    @GET
    @Path("/types/{type}")
    public Response getType(@PathParam("type") String type) {
    	List<Long> ids = new ArrayList<Long>();
    	Collection<Transaction> allTransactions = transactions.values();
    	Long i = (long) 1;
    	for (Transaction t : allTransactions) {
    		if (t.getType().equals(type))
    			ids.add(i);
    		i++;
    	}
        GenericEntity<List<Long>> entity = new GenericEntity<List<Long>>(ids) {};
        return Response.ok(entity).build();
    }
    
    @GET
    @Path("/sum/{id}")
    public Response getSum(@PathParam("id") long id) {
    	double sum = 0;
    	Transaction transaction = transactions.get(id);
    	if (transaction == null) {
    		throw new WebApplicationException(Response.Status.NOT_FOUND);
    	}
    	else {
    		sum += transaction.getAmount();
        	Collection<Transaction> allTransactions = transactions.values();
        	for (Transaction t : allTransactions) {
        		if (t.getParent_id() == id)
        			sum += t.getAmount();
        	}
            return Response.ok("{ \"sum\":"+sum+"}").build();
    	}
    }
}