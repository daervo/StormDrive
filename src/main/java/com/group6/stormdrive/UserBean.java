package com.group6.stormdrive;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class UserBean {
	public String givenname, surname, username, email, password;
	public UserBean(){
		
	}
	
	public UserBean(String givenname, String surname, String username, String email, String password){
		this.givenname = givenname;
		this.surname = surname;
		this.username = username;
		this.email = email;
		this.password = password;
	}
}
