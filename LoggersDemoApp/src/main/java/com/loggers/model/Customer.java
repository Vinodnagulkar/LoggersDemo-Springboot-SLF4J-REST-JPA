package com.loggers.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author vinod.nagulkar
 *
 */
@Entity
@Table
public class Customer 
{
 private int id;
 private String firstName;
 private String lastName;
 private String address;
 private String loginName;
 private String password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getLoginName() {
	return loginName;
}
public void setLoginName(String loginName) {
	this.loginName = loginName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
			+ ", loginName=" + loginName + ", password=" + password + "]";
}
 
}
