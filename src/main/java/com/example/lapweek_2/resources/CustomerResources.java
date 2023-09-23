package com.example.lapweek_2.resources;

import com.example.lapweek_2.models.Customer;
import com.example.lapweek_2.models.Product;
import com.example.lapweek_2.services.CustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;


@Path("/customer")
public class CustomerResources {
    private final CustomerService customerServices;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    @Inject
    public CustomerResources(CustomerService customerServices) {
        this.customerServices = customerServices;
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getCus(@PathParam("id") long cid){
        Optional<Customer> empOpt = customerServices.findbyId(cid);
        if(empOpt.isPresent()){
            return Response.ok(empOpt.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Customer> lst = customerServices.getAll();
        return Response.ok(lst).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Customer customer){
        customerServices.insert(customer);
        return Response.ok(customer).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        if (customerServices.delete(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(Customer customer){
        customerServices.update(customer);
        return Response.ok(customer).build();
    }
}
