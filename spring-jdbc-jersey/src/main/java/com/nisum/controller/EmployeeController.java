package com.nisum.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nisum.dao.EmployeeDao;
import com.nisum.employee.Employee;

@Controller
@Path("employee")
public class EmployeeController {
	@Autowired
	EmployeeDao edao;

	@Path("addemployee")
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response addEmployee(Employee e) {
		String resp = edao.saveEmployee(e);
		return Response.ok(resp).build();
	}

	@Path("updateemployee")
	@PUT
	public Response updateEmployee(Employee e) {
		String res = edao.updateEmployee(e);
		return Response.ok(res).build();
	}
	@Path("getEmployee/{eid}")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN})
	public List<Employee> getEmployeeByEid(@PathParam("eid") Integer eid) {
		System.out.println(eid);
		return edao.getByEid(eid);
	}

	@Path("removeemployee/{eid}")
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN})
	public String deleteEmployee(@PathParam("eid") Integer eid) {
		System.out.println(eid);
		return edao.deleteEmployee(eid);
	}
	@GET
	@Path("getAllEmployees")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Employee> getAllEmployees() {
		List<Employee> list = edao.getAllEmployee();
		return list;
	}
}
