package com.example.lapweek_2.resources;

import com.example.lapweek_2.models.Product;
import com.example.lapweek_2.models.Product_image;
import com.example.lapweek_2.models.Product_price;
import com.example.lapweek_2.services.ProductPriceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/productPrice")
public class ProductPriceResources {
    private final ProductPriceService productPriceServices;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    @Inject
    public ProductPriceResources(ProductPriceService productPriceServices) {
        this.productPriceServices = productPriceServices;
    }


    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Product_price productPrice){
        productPriceServices.insert(productPrice);
        return Response.ok(productPrice).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        if (productPriceServices.delete(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(Product_price productPrice){
        productPriceServices.update(productPrice);
        return Response.ok(productPrice).build();
    }
}
