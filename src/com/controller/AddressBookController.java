/**
 * 
 */
package com.controller;

import com.model.AddressBook;
import com.model.Person;
import com.serviceImplementation.AddressBookService;
import com.serviceImplementation.DBService;
import com.serviceImplementation.PersonService;
import com.serviceInterface.Service;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author bridgelabz
 *
 */
/*
 * Work with switch cases, because let's face it , you cannot make GUI so fast! 
 * Supposably "controller" is suppose to just move and control,
 * But we all know who controls you! 
 * Make GUI Fast before you forget ! 
 */
public class AddressBookController {
	
    public static void main(String args[])throws Exception {

		Scanner sc = new Scanner( System.in );
		
		System.out.println( "Welcome ! I am the Controller Here ! \n" + " I can-troll everything " );
		
		System.out.println( "I shall give you options, Choose Wisely !" );
		
		System.out.println( "How many AddressBooks are we talking about here ? " );
		
		int numberOfAddressBooks = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println( "Okay , I can controll " + numberOfAddressBooks + " Address Book(s). ");
		
		ArrayList<AddressBook> listOfAddressBooks = new ArrayList<AddressBook>();
		
		for( int booksAccesed = 0 ; booksAccesed < numberOfAddressBooks ; booksAccesed ++   ){
			
			String choice = null;
			do {
				
				System.out.println( "Now Now \n" + "Enter 1 to Load Address Book from file system, 2 to Create New Address Book , 3 to Load Address Book from DB!");
			
				choice = sc.nextLine();
			
			}while(!choice.equalsIgnoreCase("1") && !choice.equalsIgnoreCase("2") && !choice.equalsIgnoreCase("3"));
		
			if(choice.equalsIgnoreCase("1")){
			
				AddressBook elementBook = new AddressBook();
				
				Service newBookService = new AddressBookService();
				
				newBookService.fillAddressBookFromJSON(elementBook);
				
				System.out.println( "Enter Address Book ID you want to give!" );
				
				String id = sc.nextLine();
				
				elementBook.setId(id);
				
				listOfAddressBooks.add(elementBook);
				
			}
			
			if( choice.equalsIgnoreCase("2") ){
				
				AddressBook elementBook = new AddressBook();
				
				System.out.println( "Enter Address Book ID you want to give!" );
				
				String id = sc.nextLine();
				
				elementBook.setId(id);
				
				Service newBookService = new AddressBookService();
				
				newBookService.fillAddressBookDetails( elementBook );
				
				listOfAddressBooks.add(elementBook);
				
			}

			if(choice.equalsIgnoreCase("3")){

			    DBService.workWithDBForAddressBook();

            }
			
			
		}
		
		System.out.println( "Now that everything has been initialized , it's time to take con-troll !" );
		
		String choice = "";
		
		do{
			
			System.out.println( "Enter 1 to work with AddressBook , 0 to Exit!" );
			
			
			choice = sc.nextLine();
			
			if(choice.equalsIgnoreCase("1")){
				
				System.out.println( "Enter address book id !"  );
				
				String id =  sc.nextLine();
				
				Service newBookService = new AddressBookService();
				
				Service newPersonService = new PersonService();
				
				AddressBook currentBook = newBookService.searchAddressBook( listOfAddressBooks , id ); 
				
				if(currentBook != null ){
					
					String option = null;
					
					do {
					
						System.out.println( "Enter 1 to Show Details of AddressBook , 2 to Add Person to AddressBook , 3 to Delete a Person ( Forever ) , 4 to Edit information of a Person " );
				
						System.out.println(  " 5 to Sort Entries by ZipCode , 6 to Sort Entries by Name (Last and then First) , 7 to Write AddressBook to File in JSON Format " );
						
						System.out.println( "8 To show details of  a Person ,  0 To Exit this ( Matrix Neil ) " );
						
						option = sc.nextLine();
						
						if(option.equalsIgnoreCase("1")){
							
							newBookService.showAddressBookDetails( currentBook );
							
						}
						
						else if ( option.equalsIgnoreCase("2") ) {
							
							newBookService.addPerson( currentBook );
							
						}
						
						else if ( option.equalsIgnoreCase("3") ) {
							
							newBookService.deletePerson( currentBook );
							
						}
						
						else if(  option.equalsIgnoreCase("4" )   ){
							
							newPersonService.editPersonalDetails( currentBook );
							
						}
						
						else if (  option.equalsIgnoreCase("5")    ){
							
							newBookService.sortByZipCode( currentBook );
							
						}
						
						else if (  option.equalsIgnoreCase( "6")   ){
							
							newBookService.sortByName( currentBook );
							
						}
						
						else if (  option.equalsIgnoreCase("7")    ){
							
							newBookService.writeToJSONFromAddressBook( currentBook );
							
						}
						
						else if (  option.equalsIgnoreCase("8")  ){
							
							System.out.println( "Enter firstName followed by lastName" );
							
							String firstName = sc.nextLine();
							
							String lastName = sc.nextLine();
							
							Person individual = newBookService.searchPerson( currentBook, firstName, lastName );
							
							newPersonService.showPersonalDetails( individual );
							
						}
						
						else if( option.equalsIgnoreCase("0")  ){
							
							continue;
							
						}
						
						else{
							
							System.out.println(  "Invalid Option!!"   );
							
						}
					
					}while ( !option.equalsIgnoreCase("0") );
					
				}
				
				else{
					
					System.out.println( "No such AddressBook found with id :" + id );
					
					continue;
					
				}
				
			}
			
			else if( choice.equalsIgnoreCase("0") ){
				
				continue;
				
			}
			
			else{
				
				System.out.println( "Enter a valid choice!!" );
				
			}
			
			
		}while(!choice.equalsIgnoreCase("0"));
		
		
		sc.close();
	}

}
