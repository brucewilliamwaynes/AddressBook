/**
 * 
 */
package com.model;

/**
 * @author brucewilliamwaynes
 *
 */
/*
 * Person class containing Person details, name , phoneNumber and Address Object for each Person;
 */
public class Person {
private String firstName;
private String lastName;
private String phoneNumber;
private Address permanenetAddress;

public Person(){
	this.firstName = "";
	this.lastName = "";
	this.phoneNumber = "";
	this.permanenetAddress = null;
}

/**
 * @return the firstName
 */
public String getFirstName() {
	return this.firstName;
}
/**
 * @param firstName the firstName to set
 */
public void setFirstName(String firstName) {
	 this.firstName = firstName;
}
/**
 * @return the lastName
 */
public String getLastName() {
	return this.lastName;
}
/**
 * @param lastName the lastName to set
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}
/**
 * @return the phoneNumber
 */
public String getPhoneNumber() {
	return this.phoneNumber;
}
/**
 * @param phoneNumber the phoneNumber to set
 */
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
/**
 * @return the permanenetAddress
 */
public Address getPermanenetAddress() {
	return this.permanenetAddress;
}
/**
 * @param permanenetAddress the permanenetAddress to set
 */
public void setPermanenetAddress(Address permanenetAddress) {
	this.permanenetAddress = permanenetAddress;
}

}
