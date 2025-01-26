package com.springboard.internship.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userTable")
public class User {
//  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  private UUID userId; // Unique user ID generated automatically
  private String name;
  @Id
  private String email;
  private String password;
  private String contact;
  private String address;
  private String role;
  
  User(){};
  public User(String name, String email, String password,String contact,String address,String role) {
	super();
	//this.userId = UUID.randomUUID();
	this.name = name;
	this.email = email;
	this.password = password;
	this.contact=contact;
	this.address=address;
	this.role=role;
}
//public UUID getUserId() {
//	return userId;
//}
//public void setUserId(UUID userId) {
//	this.userId = userId;
//}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
@Override
public String toString() {
	return "User [ name=" + name + ", email=" + email + ", password=" + password + ", contact=" + contact + ", address=" + address + ", role=" + role + "]";
}
 
  
  
  
  
}





















