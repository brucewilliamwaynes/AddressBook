/**
 * 
 */
package com.serviceImplementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONObject;
import com.model.AddressBook;
import com.model.Person;
import com.serviceInterface.Service;
import com.utility.CommonAlgorithms;
import com.utility.FileHandlingClass;

/**
 * @author brucewilliamwaynes
 *
 */
/*
 * Abstract Class Implementing only Services pertaining to AddressBook
 */
public  class AddressBookService implements Service{

	
	public AddressBookService(){
		
	}
	
	@Override
	public void addPerson( AddressBook addressBook ){
		
		System.out.println( "Time to welcome new Member to Address Book ! " );
		
		Person individualNew = new Person();
		
		PersonService newPersonService = new PersonService();
		
		newPersonService.fillPersonalDetails( individualNew );
		
		newPersonService.showPersonalDetails( individualNew  );
		
		addPersonToAddressBook( addressBook , individualNew );
		
	}
	
	@Override
	public void addPersonToAddressBook(AddressBook addressBook, Person newIndividual) {
		// TODO Auto-generated method stub
		addressBook.getResidentList().add( newIndividual );
	}

	@Override
	public void deletePerson( AddressBook addressBook  ){
		
		Scanner sc =  new Scanner( System.in  );
		
		AddressBookService newBookService = new AddressBookService();
		
		
		System.out.println(  "Enter your first name and then last name please !! Sob Sob !! "    );
		
		String firstName = sc.nextLine();
		
		String lastName = sc.nextLine();
		
		Person individual = newBookService.searchPerson( addressBook , firstName , lastName   );
		
		if( individual != null ){
		
		System.out.println(  "So you are Leaving the Locality!! I hope you have a smooth move ( on )."   );
		
		newBookService.deletePersonFromAddressBook(   addressBook , individual   );
		
		}
		
		else{
			
			System.out.println( "Person with " + firstName + " -"   + lastName + " as name doesn't belong to the addressBook! " );
			
		}
		
	}
	
	@Override
	public void deletePersonFromAddressBook(AddressBook addressBook, Person individual) {
		// TODO Auto-generated method stub
		addressBook.getResidentList().remove(individual);
	}

	@Override
	public int getTotalPopulation(AddressBook addressBook) {
		// TODO Auto-generated method stub
		return addressBook.getResidentList().size();
	}

	@Override
	public Person searchPerson ( AddressBook addressBook, String firstName, String lastName ) {
		// TODO Auto-generated method stub
		for( Person individual : addressBook.getResidentList() ){
			if( individual.getFirstName().equalsIgnoreCase( firstName )  &&   individual.getLastName().equalsIgnoreCase( lastName ) )
				return individual;
		}
		return null;
	}

	@Override
	public void sortByName( AddressBook addressBook ){
		
		Person personAye = null;
		
		Person personJai = null;
		
		for(  int i = 0; i <  addressBook.getResidentList().size()  ; i ++ ){
			
			for(  int j = 0; j  <  addressBook.getResidentList().size() - i - 1 ; j ++  ){
				
					personJai = addressBook.getResidentList().get(j);
					
					personAye = addressBook.getResidentList().get(j+1);
					
					if(personJai.getLastName().compareTo(personAye.getLastName()) == 0){
							
						if( personJai.getFirstName().compareTo(personAye.getLastName()) > 0 ){
							
							CommonAlgorithms.swapPerson(personAye, personJai);
							
						}
						
					}
					else if(personJai.getLastName().compareTo(personAye.getLastName() ) > 0 ){
												
						CommonAlgorithms.swapPerson( personAye, personJai );
						
					}
				
					else{
						continue;
					}
					
			}
			
		}	
		
	}
	
	@Override
	public void sortByZipCode( AddressBook addressBook ){
		
		Person personAye = null;
		
		Person personJai = null;
		
		for(  int i = 0; i <  addressBook.getResidentList().size()  ; i ++ ){
			
			for(  int j = 0; j  <  addressBook.getResidentList().size() - i - 1 ; j ++  ){
				
					personJai = addressBook.getResidentList().get(j);
					
					personAye = addressBook.getResidentList().get(j+1);
					
					if(personJai.getPermanenetAddress().getPincode().compareTo(personAye.getPermanenetAddress().getPincode()) > 0){
							
						CommonAlgorithms.swapPerson( personAye, personJai );
						
					}
										
			}
			
		}
		
		
	}
	
	@Override
	public void fillAddressBookDetails(  AddressBook addressBook   ){
		
	
		Scanner sc = new Scanner( System.in  );
		
		ArrayList<Person> listOfNewPeople = new ArrayList<Person>();
		
		Service newPersonService = new PersonService();
		
		System.out.println ( "Number of people you want to add in address book with id : "   + addressBook.getId() ) ;
		
		int limit = sc.nextInt();
		
			for(int addPerson = 0 ; addPerson < limit ; addPerson++){
			
				System.out.println( "Time to add person !" );
					
				Person individual = new Person();
				
				newPersonService.fillPersonalDetails( individual );
				
				listOfNewPeople.add( individual );
				
			}
		
		
		addressBook.setResidentList( listOfNewPeople );
		
		
	}
	
	
	
	@Override
	public void showAddressBookDetails( AddressBook addressBook  ){
		
		System.out.println( "Address Book Id :" + addressBook.getId() );

		System.out.println( "Total Population here is : " + getTotalPopulation( addressBook )   );
		
		Service newService = new PersonService();
		
		for ( Person individual : addressBook.getResidentList()){
			
			newService.showPersonalDetails(individual);
			
		}
		
		System.out.println( "Details of Address Book End Here!"  );
		
	}
	
	@Override
	public AddressBook searchAddressBook( ArrayList<AddressBook> listOfBooks ,  String id  ){
		
		for( AddressBook book : listOfBooks  ){
		
			if(book.getId().equalsIgnoreCase(id))
				return book;
			
		}
		
		return null;
	
	}
	
	
	
	@Override
	public void fillAddressBookFromJSON( AddressBook addressBook ) throws Exception{
		
		JSONObject addressBookObj = FileHandlingClass.readJSONFromFile();
		
		ArrayList<Person> listOfPeople = addressBook.getResidentList();
		
		Person individualPerson = null;
		
		PersonService newPersonService = new PersonService();
		
		for( Object key : addressBookObj.keySet() ){
			
			JSONObject individual = ( JSONObject )addressBookObj.get( key );
			
			individualPerson = new Person();
			
			newPersonService.fillPersonDetailsFromJSON( individual, individualPerson );
			
			listOfPeople.add( individualPerson );
		
		}
	
	}
	
	@Override
	public void writeToJSONFromAddressBook( AddressBook addressBook ) throws IOException{
		
		JSONObject addressBookJSONObj = new JSONObject();
		
		JSONObject personJSONObj = null ; 
		
		ArrayList<Person> listOfPeople = addressBook.getResidentList();
			
		PersonService newPersonService = new PersonService();
		
		for( Person individual : listOfPeople ){
			
			personJSONObj = new JSONObject();
			
			 newPersonService.writeToJSONFromPerson( personJSONObj , individual );
			
			addressBookJSONObj.put( individual.getPhoneNumber() , personJSONObj	);
			
			FileHandlingClass.writeJSONToFile( addressBookJSONObj );
			
		}
		
	}

	@Override
	public void editPersonalDetails(AddressBook addressBook) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editPersonDetailsInAddressBook(AddressBook addressBook, Person individual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showAddressDetails(Person individual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillAddressDetails(Person individual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showPersonalDetails(Person individual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillPersonalDetails(Person indiviudal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillPersonDetailsFromJSON(JSONObject personJSONObj, Person individual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillAddressDetailsFromJSON(JSONObject personJSONObj, Person individual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeToJSONFromPerson(JSONObject personJSONObj, Person individual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeToJSONFromAddress(JSONObject personJSONObj, Person individual) {
		// TODO Auto-generated method stub
		
	}
	
}
