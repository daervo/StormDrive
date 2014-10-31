package com.group6.stormdrive;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import com.wordnik.swagger.annotations.*;
import apis.StormDrive;

@Path("/stormdriveapi")
@Api(value = "/stormdriveapi", description = "StormDrive api ")
@Produces("application/json")
public class StormDriveService {

	@GET
	@Path("/{parameter}")
	@ApiOperation(value = "API Access check", notes = "this method just to check the api is working so what ever you pass as an argument you'll get it back", response = StormDrive.class)
	
	public Response responseMsg( @PathParam("parameter") String parameter,
			@DefaultValue("Nothing to say") @QueryParam("value") String value) {

		String output = "Hello from: " + parameter + " : " + value;

		return Response.status(200).entity(output).build();
	}

<<<<<<< HEAD
	@PUT
	@Path("/user")
	@ApiOperation(value = "Change user Password")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid username supplied"),
		      @ApiResponse(code = 404, message = "user not found") })
	@Produces("text/html")
	public Response setPassword ( @ApiParam(value = "The Username", required = true)@FormParam("username") String username,
			@ApiParam(value = "The Password", required = true)@FormParam("password") String password){
=======
	@POST
	@Path("/setpassword")
	public Response setPassword ( @FormParam("username") String username,
			@FormParam("password") String password){
>>>>>>> parent of cf6d97d... fixed it. did the changes

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

<<<<<<< HEAD
	@GET
	@Path("/user")
	@ApiOperation(value = "user authentication")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid username supplied"),
		      @ApiResponse(code = 404, message = "user not found") })
	public Response login ( @ApiParam(value = "The Username", required = true) @DefaultValue("null") @QueryParam("username") String username,
			@ApiParam(value = "The Password", required = true) @DefaultValue("null") @QueryParam("password") String password){
=======
	@POST //because we don't want to put the password in the URL
	@Path("/authenticate")
	public Response login ( @FormParam("username") String username,
			@FormParam("password") String password){
>>>>>>> parent of cf6d97d... fixed it. did the changes

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
<<<<<<< HEAD
	@Path("/user")
	@ApiOperation(value = "Register new user")
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Record Already Exist"), @ApiResponse(code = 405, message = "Invalid input") })
	@Produces("application/json")
	public UserBean registerJSON (@ApiParam(value = "The Given Name", required = true) @FormParam("givenname") String givenname,
			@ApiParam(value = "The Sur Name", required = true) @FormParam("surname") String surname,
			@ApiParam(value = "The Username", required = true)@FormParam("username") String username,
			@ApiParam(value = "The Password", required = true)@FormParam("password") String password,
			@ApiParam(value = "E-mail Address", required = true)@FormParam("email") String email){
=======
	@Path("/register")
	public Response register ( @FormParam("givenname") String givenname,
			@FormParam("surname") String surname,
			@FormParam("username") String username,
			@FormParam("password") String password,
			@FormParam("email") String email){
>>>>>>> parent of cf6d97d... fixed it. did the changes

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
	@ApiOperation(value = "Register an admin user")
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Record Already Exist"), @ApiResponse(code = 405, message = "Invalid input") })
	@Produces("application/json")
	public Response createAdmin ( @ApiParam(value = "The Given Name", required = true) @FormParam("givenname") String givenname,
			@ApiParam(value = "The Sur Name", required = true) @FormParam("surname") String surname,
			@ApiParam(value = "The Username", required = true)@FormParam("username") String username,
			@ApiParam(value = "The Password", required = true) @FormParam("password") String password,
			@ApiParam(value = "E-mail Address", required = true) @FormParam("email") String email){

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
	@ApiOperation(value = "Get user Details")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid username supplied"),
		      @ApiResponse(code = 404, message = "user not found") })
	public Response getDetails( @ApiParam(value = "The Username", required = true) @PathParam("username") String username) {

		return Response.status(200).entity(StormDrive.getDetails(username)).build();
	}
}