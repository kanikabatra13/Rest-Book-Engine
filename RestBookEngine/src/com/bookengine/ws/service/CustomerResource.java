package com.bookengine.ws.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import com.bookengine.ws.service.representation.CustomerRepresentation;
import com.bookengine.ws.service.representation.CustomerRequest;
import com.bookengine.ws.service.workflow.CustomerActivity;

@CrossOriginResourceSharing(allowAllOrigins = true)

@Path("/customer")
public class CustomerResource {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/")
	public List<CustomerRepresentation> getCustomers() {
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.getCustomers();
	}
	
	@GET
	@Path("/valid")
	public Response customerAuth(@QueryParam("username") String username, @QueryParam("password") String password) {
		CustomerActivity customerActivity = new CustomerActivity();
		if (customerActivity.authenticate(username, password) == null) {
			return Response.status(Status.UNAUTHORIZED).build();
		}
		return Response.status(Status.OK).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/{Custid}")
	public CustomerRepresentation getCustomer(@PathParam("id") String id) {
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.getCustomer(id);
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/")
	public CustomerRepresentation createCustomer(CustomerRequest customerRequest) {
		CustomerActivity customerActivity = new CustomerActivity();
		return customerActivity.createCustomer(customerRequest.getName(), customerRequest.getAddress(),
				customerRequest.getPhone(), customerRequest.getBooks());
	}

}
