package com.example.lapweek_2.resources;

import com.example.lapweek_2.models.Order;
import com.example.lapweek_2.models.Product;
import com.example.lapweek_2.services.OrderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Path("/order")
public class OrderResources {
    private final OrderService orderServices;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    @Inject
    public OrderResources(OrderService orderServices) {
        this.orderServices = orderServices;
    }


    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Order> lst = orderServices.getAll();
        return Response.ok(lst).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Order order){
        orderServices.insert(order);
        return Response.ok(order).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        if (orderServices.delete(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(Order order){
        orderServices.update(order);
        return Response.ok(order).build();
    }

}
