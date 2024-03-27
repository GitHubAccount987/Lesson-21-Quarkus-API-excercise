package cz.spsmb.rest;

import cz.spsmb.dao.EmployeeRepository;
import cz.spsmb.model.Employee;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/employees")
public class EmployeeResource {

    @Inject
    EmployeeRepository employeeRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response list() {
        List<Employee> employee = employeeRepository.listAll();
        return Response.ok().entity(employee).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteById(@PathParam("id") Long id) {
        employeeRepository.deleteById(id);
        return Response.ok().entity("ok").build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response save(Employee employee) {
        employee.setId(0l);
        employeeRepository.persist(employee);
        return Response.ok().entity("ok").build();
    }
}