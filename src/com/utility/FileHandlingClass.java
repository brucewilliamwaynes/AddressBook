/**
 * 
 */
package com.utility;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author brucewilliamwaynes
 *
 */
public class FileHandlingClass {
    
	
	public static JSONObject readJSONFromFile()throws Exception {
    	
		Scanner sc = new Scanner(System.in);
    	
		System.out.println("Enter destination of input file!");
    	
		String inputDestination = sc.nextLine();
        
		Object fileObj = new JSONParser().parse(new FileReader(inputDestination));
        
		JSONObject jsonObj = (JSONObject) fileObj;
        
		return jsonObj;
    
	}
	
	public static void writeJSONToFile( JSONObject fileJSONObj ) throws IOException {
		
		Scanner sc = new Scanner(System.in);
    	
		System.out.println("Enter destination of output file!");
    	
		String inputDestination = sc.nextLine();
        
		PrintWriter outputFile = new PrintWriter(inputDestination);
		
        outputFile.write( fileJSONObj.toJSONString() );
        
        outputFile.flush();
        
        outputFile.close();
	
	}
	
}
