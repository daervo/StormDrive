package com.group6.stormdrive;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import apis.StormDrive;

@Path("/stormdriveapi")
public class StormDriveService {

	@GET
	@Path("/{parameter}")
	public Response responseMsg( @PathParam("parameter") String parameter,
			@DefaultValue("Nothing to say") @QueryParam("value") String value) {

		String output = "Hello from: " + parameter + " : " + value;

		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/setpassword/{username}")
	public Response setPassword ( @PathParam("username") String username,
			@DefaultValue("thisisaS3cret") @QueryParam("value") String password){

		String output = "Password Changed";
		if (StormDrive.setPassword(username, password)){
			output = "Password Changed";
			System.out.println(output);
			return Response.status(200).entity(output).build();
		}else{
			output = "Error";
			System.out.println(output);
			return Response.status(500).entity(output).build();
		}
	}
	
	@GET
	@Path("/getdetails/{username}")
	public Response getDetails( @PathParam("username") String username) {

		return Response.status(200).entity(StormDrive.getDetails(username)).build();
	}
}