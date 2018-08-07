/**
 * 
 */
package com.serviceInterface;



import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.model.Address;
import com.model.AddressBook;
import com.model.Person;

/**
 * @author brucewilliamwaynes
 *
 */
/*
 * Interface with abstract methods to be implemented in serviceImplementation package.
 * Person and Address related abstract methods are all in "Service" Interface 
 * Need to implement PersonService Interface and AddressService Interface and 
 * Make them, a part of this "Service" Interface
 */

public interface Service {

public AddressBook searchAddressBook( ArrayList<AddressBook> listOfBooks , String id );
public void fillAddressBookDetails(  AddressBook addressBook   );
public void showAddressBookDetails( AddressBook addressBook  );
public void addPerson(AddressBook addressBook);
public void addPersonToAddressBook(AddressBook addressBook,Person newIndividual);
public void deletePerson( AddressBook addressBook );
public void deletePersonFromAddressBook(AddressBook addressBook,Person individual);
public void editPersonalDetails( AddressBook addressBook  );
public void editPersonDetailsInAddressBook(AddressBook addressBook, Person individual);
public int getTotalPopulation(AddressBook addressBook);
public Person searchPerson(AddressBook addressBook, String firstlName,String lastName);
public void showAddressDetails( Person individual );
public void fillAddressDetails( Person individual );
public void showPersonalDetails(Person individual);
public void fillPersonalDetails( Person indiviudal );
public void sortByZipCode(AddressBook addressBook);
public void sortByName(AddressBook addressBook);
public void fillAddressBookFromJSON(AddressBook addressBook) throws Exception;
public void fillPersonDetailsFromJSON( JSONObject personJSONObj , Person individual );
public void fillAddressDetailsFromJSON( JSONObject personJSONObj ,  Person individual );
public void writeToJSONFromAddressBook(AddressBook addressBook) throws IOException;
public void writeToJSONFromPerson(JSONObject personJSONObj , Person individual );
public void writeToJSONFromAddress( JSONObject personJSONObj , Person individual );

}
