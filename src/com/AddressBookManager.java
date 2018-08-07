/**
 * 
 */
package com;

import java.io.IOException;
import java.util.Scanner;

import com.controller.AddressBookController;

/**
 * @author bridgelabz
 *
 */
public class AddressBookManager {

	public static void main(String args[])throws Exception {
		
		Scanner sc = new Scanner( System.in   );
		
		System.out.println(  "Where do you want to load address book from? "    );
		
		System.out.println( "1 to Load or Work with JSON , and 2 to load and Work with JSON"   );
		
		String choice = sc.nextLine();
		
		if( choice.equals("1")){
			
			AddressBookController.runForJSON();
			
		}
		
		else if(choice.equals("2")){
			
			
			
		}
		
	}
	
}
