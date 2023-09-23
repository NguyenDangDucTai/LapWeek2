package com.example.lapweek_2.resources;

import com.example.lapweek_2.models.Order_detail;
import com.example.lapweek_2.models.Product;
import com.example.lapweek_2.services.OrderDetailService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;


@Path("/orderDetail")
public class OrderDetailResources {

    private final OrderDetailService orderDetailServices;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    @Inject
    public OrderDetailResources(OrderDetailService orderDetailServices) {
        this.orderDetailServices = orderDetailServices;
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Order_detail orderDetail){
        orderDetailServices.insert(orderDetail);
        return Response.ok(orderDetail).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        if (orderDetailServices.delete(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(Order_detail orderDetail){
        orderDetailServices.update(orderDetail);
        return Response.ok(orderDetail).build();
    }
}
