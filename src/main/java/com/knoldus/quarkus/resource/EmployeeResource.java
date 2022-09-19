package com.knoldus.quarkus.resource;

import com.knoldus.quarkus.model.Employee;
import com.knoldus.quarkus.service.EmployeeService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @Inject
    EmployeeService employeeService;

    @POST
    public Response createEmployee(@Valid Employee employee) {
        employeeService.createEmployee(employee);
        return Response.accepted().build();
    }
}
