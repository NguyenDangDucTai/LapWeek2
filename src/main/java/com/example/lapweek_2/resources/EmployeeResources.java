package com.example.lapweek_2.resources;

import com.example.lapweek_2.models.Employee;
import com.example.lapweek_2.models.Product;
import com.example.lapweek_2.services.EmployeeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Path("/employee")
public class EmployeeResources {
    private final EmployeeService employeeServices;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    @Inject
    public EmployeeResources(EmployeeService employeeServices) {
        this.employeeServices = employeeServices;
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getEmp(@PathParam("id") long eid){
        Optional<Employee> empOpt = employeeServices.findbyId(eid);
        if(empOpt.isPresent()){
            return Response.ok(empOpt.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Employee> lst = employeeServices.getAll();
        return Response.ok(lst).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Employee employee){
        employeeServices.inssertEmp(employee);
        return Response.ok(employee).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id){
        if (employeeServices.delete(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(Employee employee){
        employeeServices.update(employee);
        return Response.ok(employee).build();
    }




}
