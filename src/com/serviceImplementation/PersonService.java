/**
 * 
 */
package com.serviceImplementation;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONObject;

import com.model.Address;
import com.model.AddressBook;
import com.model.Person;
import com.serviceInterface.Service;

/**
 * @author brucewilliamwaynes
 *
 */
/*
 * PersonService : Abstract class implementing methods pertaining to Person Class details
 */
public class PersonService implements Service{
	
	public PersonService(){
		
	}
	
	@Override
	public void editPersonalDetails( AddressBook addressBook  ){
		
		Scanner sc = new Scanner( System.in  );
		
		System.out.println( "Please Enter your first name and then your last name !"  );
		
		String firstName = sc.nextLine();
		
		String lastName = sc.nextLine();
		
		AddressBookService newBookService = new AddressBookService();
		
		Person individual = newBookService.searchPerson( addressBook , firstName , lastName   );
		
		if( individual != null ){
			
			editPersonDetailsInAddressBook( addressBook , individual  );
			
		}
		
		else{
			
			System.out.println( "Person with " + firstName + " -"   + lastName + " as name doesn't belong to the addressBook! " );
			
		}
		
		
		
	}
	
	
	

	@Override
	public  void editPersonDetailsInAddressBook(AddressBook addressBook, Person individual) {
		// TODO Auto-generated method stub
		System.out.println( "Hey " + individual.getFirstName() + " Having a pun day! \n" + "So, you decided to move again! Perhaps change your phone number too!" );
		
		boolean choice = false;
		Scanner sc  =new Scanner(System.in);
		
		System.out.println( "Help me decide ! \n" + "Do you want to change  PhoneNumber ? ( true / false ) ");;
			
		choice = sc.nextBoolean();
		
		if(choice){
			
			String phoneNumber = "";
			
			do {
			
			System.out.println( " Enter new phoneNumber " );
			
			phoneNumber = sc.nextLine();
		
			}while( phoneNumber.length() != 10 );
			 
			System.out.println( " Your old phone Number was " + individual.getPhoneNumber() + " \n Your new phone Number is " + phoneNumber);
			
			individual.setPhoneNumber(phoneNumber);
			
		}
		
		System.out.println( "Help me decide ! \n" + "Do you want to change your residential Address! ( true / false ) ");
	
		choice = sc.nextBoolean();
		
		if( choice ){
			
			System.out.println(" Enter Flat number ! Then Building Name ! Then Street Number ! Then Landmark ! Then City ! Then State ! Then Zipcode ! ");
			
			String inputString = sc.nextLine();
			
			individual.getPermanenetAddress().setFlatNumber(inputString);
			
			inputString = sc.nextLine();
			
			individual.getPermanenetAddress().setBuildingName(inputString);
			
			inputString = sc.nextLine();
			
			individual.getPermanenetAddress().setStreetNumber(inputString);
		
			inputString = sc.nextLine();
			
			individual.getPermanenetAddress().setLandMarkNearest(inputString);
			
			inputString = sc.nextLine();
			
			individual.getPermanenetAddress().setCity(inputString);
			
			inputString = sc.nextLine();
			
			individual.getPermanenetAddress().setState(inputString);
			
			inputString =  sc.nextLine();
			
			individual.getPermanenetAddress().setPincode(inputString);
						
		}
		
		System.out.println( " Changes made to your details! " );

		
		
	}
	
	@Override
	public void fillAddressDetails( Person individual ){
		
		Address addressNew =  new Address();
		
		Scanner sc = new Scanner( System.in );
		
		System.out.println(" Enter Flat number ! Then Building Name ! Then Street Number ! Then Landmark ! Then City ! Then State ! Then Zipcode ! ");
		
		String inputString = sc.nextLine();
		
		addressNew.setFlatNumber(inputString);
		
		inputString = sc.nextLine();
		
		addressNew.setBuildingName(inputString);
		
		inputString = sc.nextLine();
		
		addressNew.setStreetNumber(inputString);
	
		inputString = sc.nextLine();
		
		addressNew.setLandMarkNearest(inputString);
		
		inputString = sc.nextLine();
		
		addressNew.setCity(inputString);
		
		inputString = sc.nextLine();
		
		addressNew.setState(inputString);
		
		inputString =  sc.nextLine();
		
		addressNew.setPincode(inputString);
		
		
		
		individual.setPermanenetAddress(addressNew);
		
	}
	
	@Override
	public void showAddressDetails( Person individual ){
		
		System.out.println("Your registered address is : \n" + individual.getPermanenetAddress().getFlatNumber() + "," + individual.getPermanenetAddress().getBuildingName() + " ,");
		
		System.out.println(individual.getPermanenetAddress().getStreetNumber() + "," + individual.getPermanenetAddress().getLandMarkNearest() + ",");
		
		System.out.println(individual.getPermanenetAddress().getCity() + ",\n" + individual.getPermanenetAddress().getState() + "-" + individual.getPermanenetAddress().getPincode() + ".");
		
	}
	
	@Override
	public void fillPersonalDetails( Person individual ){
		
		Scanner sc = new Scanner( System.in );
		
		System.out.println( "Enter First Name ! Then Last Name ! Then Phone Number " );
		
		String inputString = sc.nextLine();
		
		individual.setFirstName(inputString);

		inputString = sc.nextLine();
		
		individual.setLastName(inputString);;
		
		inputString = sc.nextLine();
		
		individual.setPhoneNumber(inputString);
		
		fillAddressDetails( individual );
		
		
	}
	
	
	
	@Override
	public void showPersonalDetails( Person individual ){
		
		System.out.println("Hey , \n" + individual.getFirstName() + " " + individual.getLastName());
		
		System.out.println( "Your registered Phone Number is " + individual.getPhoneNumber()  );
		
		showAddressDetails(individual);
		
		System.out.println( "That's all we got !" );		
	}
	
	@Override
	public void fillPersonDetailsFromJSON( JSONObject personJSONObj , Person individual ){
		
		individual.setFirstName((String) personJSONObj.get("FirstName"));
		
		individual.setLastName((String) personJSONObj.get("LastName"));
		
		individual.setPhoneNumber((String) personJSONObj.get("PhoneNumber"));
		
		fillAddressDetailsFromJSON( personJSONObj , individual );
		
	}
	
	@Override
	public void fillAddressDetailsFromJSON( JSONObject personJSONObj , Person individual  ){
		
		Address addressNew = new Address();
		
		addressNew.setFlatNumber((String) personJSONObj.get("FlatNumber"));
		
		addressNew.setBuildingName((String) personJSONObj.get("BuildingName"));
		
		addressNew.setStreetNumber((String) personJSONObj.get("StreetNumber"));
		
		addressNew.setLandMarkNearest((String) personJSONObj.get("LandMark"));
		
		addressNew.setCity((String) personJSONObj.get("City"));
		
		addressNew.setState((String) personJSONObj.get("State"));
		
		addressNew.setPincode((String) personJSONObj.get("ZipCode"));
		
		individual.setPermanenetAddress(addressNew);		
		
	}
	
	@Override
	public void writeToJSONFromPerson( JSONObject personJSONObj , Person individual ){
		
		personJSONObj.put( "FirstName", individual.getFirstName() );
		
		personJSONObj.put( "LastName", individual.getLastName() );
		
		personJSONObj.put( "PhoneNumber", individual.getPhoneNumber() );
		
		writeToJSONFromAddress( personJSONObj , individual );
		
	}
	
	@Override
	public void writeToJSONFromAddress( JSONObject personJSONObj , Person individual ){
		
		Address addressNew = individual.getPermanenetAddress();
		
		personJSONObj.put( "FlatNumber", addressNew.getFlatNumber() );
		
		personJSONObj.put( "BuildingName", addressNew.getBuildingName() );
		
		personJSONObj.put( "StreetNumber", addressNew.getStreetNumber() );
		
		personJSONObj.put( "LandMark", addressNew.getLandMarkNearest() );
		
		personJSONObj.put( "City", addressNew.getCity() );
		
		personJSONObj.put( "State", addressNew.getState() );
		
		personJSONObj.put( "ZipCode", addressNew.getPincode() );
		
	}

	@Override
	public AddressBook searchAddressBook(ArrayList<AddressBook> listOfBooks, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillAddressBookDetails(AddressBook addressBook) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showAddressBookDetails(AddressBook addressBook) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPerson(AddressBook addressBook) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPersonToAddressBook(AddressBook addressBook, Person newIndividual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePerson(AddressBook addressBook) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePersonFromAddressBook(AddressBook addressBook, Person individual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalPopulation(AddressBook addressBook) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Person searchPerson(AddressBook addressBook, String firstlName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sortByZipCode(AddressBook addressBook) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortByName(AddressBook addressBook) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillAddressBookFromJSON(AddressBook addressBook) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeToJSONFromAddressBook(AddressBook addressBook) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}
