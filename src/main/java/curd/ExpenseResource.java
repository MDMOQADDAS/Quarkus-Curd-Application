package curd;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;
import java.util.UUID;

//this file taking care of internet part, it will define the path and what kind of service i can expose to the public
@Tag(name = "My Personal Expense Application") //this is used to give the custom name of the resources in swagger ui

@Path("/expense")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExpenseResource {

    @Inject
    ExpenseService expenseService;



    @GET
    public Set<Expense> mylist(){

        return expenseService.list();
    }

    @POST
    public Expense  mycreate(Expense expense){
        return expenseService.create(expense);
    }

    @DELETE
    @Path("{uuid}")
    public boolean mydelete(@PathParam("uuid") UUID uuid){
        return expenseService.delete(uuid);
    }

    @PUT
    public void myupdate(Expense expense){
        expenseService.update(expense);
    }
}
