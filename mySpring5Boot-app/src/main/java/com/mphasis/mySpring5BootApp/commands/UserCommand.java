package com.mphasis.mySpring5BootApp.commands;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("deprecation")
public class UserCommand {

	@NotBlank
	@Email
	@Size(min=4 ,max=20)
	private String email;
	@NotBlank
	@Size(min=1 ,max=50)
	private String name;
	@NotBlank
	@Size(min=3, max=16)
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
