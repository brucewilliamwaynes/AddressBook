/**
 * 
 */
package com.model;

import java.util.ArrayList;

/**
 * @author brucewiiliamwaynes
 *
 */
/*
 * Single instance of addressBook for to
 * extend into multiple instances of addressBook
 * including residents' details
 */
public class AddressBook {

	private String id;
private ArrayList<Person> residentList;

	public AddressBook(){
		this.setId("");
		this.residentList = new ArrayList<Person>();
	}

/**
 * @return the residentList
 */
public ArrayList<Person> getResidentList() {
	return residentList;
}

/**
 * @param residentList the residentList to set
 */
public void setResidentList(ArrayList<Person> residentList) {
	this.residentList = residentList;
}

/**
 * @return the id
 */
public String getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(String id) {
	this.id = id;
}
 }
