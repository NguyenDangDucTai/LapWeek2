package com.example.lapweek_2.resources;

import com.example.lapweek_2.models.Product;
import com.example.lapweek_2.models.Product_image;
import com.example.lapweek_2.services.ProductImageService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Path("/product")
public class ProductImageResources {
    private final ProductImageService productImageServices;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    @Inject
    public ProductImageResources(ProductImageService productImageServices) {
        this.productImageServices = productImageServices;
    }


    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Product_image productImage){
        productImageServices.insert(productImage);
        return Response.ok(productImage).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        if (productImageServices.delete(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(Product_image product_image){
        productImageServices.update(product_image);
        return Response.ok(product_image).build();
    }
}
