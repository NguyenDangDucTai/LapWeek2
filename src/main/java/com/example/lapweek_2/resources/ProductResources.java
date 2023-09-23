package com.example.lapweek_2.resources;

import com.example.lapweek_2.models.Employee;
import com.example.lapweek_2.models.Product;
import com.example.lapweek_2.models.Product_image;
import com.example.lapweek_2.services.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Path("/product")
public class ProductResources {
    private final ProductService productServices;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    @Inject
    public ProductResources(ProductService productServices) {
        this.productServices = productServices;
    }


    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Product product){
        productServices.insert(product);
        return Response.ok(product).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        if (productServices.delete(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(Product product){
        productServices.update(product);
        return Response.ok(product).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getEmp(@PathParam("id") long eid){
        Optional<Product> empOpt = productServices.findById(eid);
        if(empOpt.isPresent()){
            return Response.ok(empOpt.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Product> lst = productServices.getAll();
        return Response.ok(lst).build();
    }
}
