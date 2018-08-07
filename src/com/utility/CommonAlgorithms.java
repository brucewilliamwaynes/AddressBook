/**
 * 
 */
package com.utility;

import com.model.Address;
import com.model.Person;

/**
 * @author brucewilliamwaynes
 *
 */
/*
 * Implementing some common functions to be used VIA AddressBook Controller!
 */
public class CommonAlgorithms {
		
	public static void swapPerson( Person person1, Person person2 ){
		
		Person tempPerson = new Person();
		
		tempPerson.setFirstName(person1.getFirstName());
		
		tempPerson.setLastName(person1.getLastName());
		
		tempPerson.setPhoneNumber(person1.getPhoneNumber());
		
		copyAddress( tempPerson , person1 );
		
		person1.setFirstName(person2.getFirstName());
		
		person1.setLastName(person2.getLastName());
		
		person1.setPhoneNumber(person2.getPhoneNumber());
		
		copyAddress( person1 , person2 );
		
		person2.setFirstName( tempPerson.getFirstName());
		
		person2.setLastName( tempPerson.getLastName());
		
		person2.setPhoneNumber( tempPerson.getPhoneNumber());
		
		copyAddress( person2 , tempPerson );
		
	}

	private static void copyAddress(Person tempPerson, Person person1) {
		// TODO Auto-generated method stub
		Address tempAddress = new Address();
		
		tempAddress.setFlatNumber(person1.getPermanenetAddress().getFlatNumber());
		
		tempAddress.setBuildingName(person1.getPermanenetAddress().getBuildingName());
		
		tempAddress.setStreetNumber(person1.getPermanenetAddress().getStreetNumber());
		
		tempAddress.setLandMarkNearest(person1.getPermanenetAddress().getLandMarkNearest());
		
		tempAddress.setCity(person1.getPermanenetAddress().getCity());
		
		tempAddress.setState(person1.getPermanenetAddress().getState());
		
		tempAddress.setPincode(person1.getPermanenetAddress().getPincode());
		
		tempPerson.setPermanenetAddress(tempAddress);
		
	}
	
}
