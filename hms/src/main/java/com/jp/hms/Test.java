package com.jp.hms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {



		
	    public static void main(String[] args) throws ParseException {
	        // Create a Date object representing the current date and time
	        Date currentDate = new Date();
	        
	        // Create a SimpleDateFormat instance with the desired format
	        Date dateFormat = new SimpleDateFormat("dd-MM-yyyy").parse(null);
	        
//	        // Format the Date object as a string
//	        String formattedDate = dateFormat.format(currentDate);
//	        
//	        // Display the formatted date
//	        System.out.println("Formatted Date: " + formattedDate);
	        
	        
	    }


}
