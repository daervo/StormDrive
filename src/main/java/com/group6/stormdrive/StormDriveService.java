package com.group6.stormdrive;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
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

	@POST
	@Path("/setpassword")
	public Response setPassword ( @FormParam("username") String username,
			@FormParam("password") String password){

		String output = "Password Changed";
		if (username != null && password != null && StormDrive.setPassword(username, password)){
			output = "Password Changed";
			System.out.println(output);
			return Response.status(200).entity(output).build();
		}else{
			output = "Error";
			System.out.println(output);
			return Response.status(500).entity(output).build();
		}
	}

	@POST //because we don't want to put the password in the URL
	@Path("/authenticate")
	public Response login ( @FormParam("username") String username,
			@FormParam("password") String password){

		String output = "";
		if (username != null && password != null && StormDrive.login(username, password)){
			output = "Authenticated";
			System.out.println(output);
			return Response.status(200).entity(output).build();
		}else{
			output = "Username or password is wrong";
			System.out.println(output);
			return Response.status(500).entity(output).build();
		}
	}

	@POST //because we don't want to put the password in the URL
	@Path("/register")
	public Response register ( @FormParam("givenname") String givenname,
			@FormParam("surname") String surname,
			@FormParam("username") String username,
			@FormParam("password") String password,
			@FormParam("email") String email){

		boolean valid = givenname != null ||
				surname != null||
				username != null||
				password != null||
				email != null;
		String output;
		
		if (valid && StormDrive.register(givenname, surname, username, password, email)){
			output = "Registration Success!";
			System.out.println(output);
			return Response.status(200).entity(output).build();
		}else{
			output = "Registration unsuccessful";
			System.out.println(output);
			return Response.status(500).entity(output).build();
		}
	}

	@POST //because we don't want to put the password in the URL
	@Path("/createadmin")
	public Response createAdmin ( @FormParam("givenname") String givenname,
			@FormParam("surname") String surname,
			@FormParam("username") String username,
			@FormParam("password") String password,
			@FormParam("email") String email){

		boolean valid = givenname != null ||
				surname != null||
				username != null||
				password != null||
				email != null;
		String output;
		
		if (valid && StormDrive.createAdmin(givenname, surname, username, password, email)){
			output = "Registration Success!";
			System.out.println(output);
			return Response.status(200).entity(output).build();
		}else{
			output = "Registration unsuccessful";
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