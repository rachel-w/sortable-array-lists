/*************************************************************
  Modified form NameListDriver code provided in class
  to test SortableArrayListWithStack
  Rachel Wey
  StringListDriver.java
*/

import java.util.*;
import java.io.*;


class StringListDriver
{
  @SuppressWarnings("resource")
public static void main(String args[])
  {  
     
	 // Set up scanner for keyboard input 
	 Scanner keyboard = new Scanner(System.in);
	  
	 // Set up input file
	 System.out.println("Enter the name of a file with a list of strings to be sorted:");
	 String fileName = keyboard.nextLine();
	 File stringFile = new File(fileName);
    
    // Set up file scanner
	 Scanner stringFileScanner;
	  
    try
	 {
	   stringFileScanner = new Scanner(stringFile);
	 }
	 catch (FileNotFoundException fnfe)
	 {
	   System.out.println("File " + fileName + " not found: terminating program");
		return;
	 }
	 
    // Read strings into list 
	 String currentString;
	 
	 
	 
	 //Decide which stack type to use
	 System.out.println("Pick a stack to use. Press A for array and L for linked list: ");
	 String stackType=keyboard.nextLine();
	 
	 SortableArrayList<String> stringList
         = new SortableArrayListWithQuickSort<String>(stackType);
									 	  
	 // Get strings from file and add to list
	 while (stringFileScanner.hasNext())
	 {
	   currentString = stringFileScanner.next();	  
	   stringList.append(currentString); 
  	 } // input while loop
	  
	 // Print original list
	 System.out.println("\nThe strings in their unsorted order:\n");
    Iterator<String> stringListIterator = stringList.getIterator();
    
    while(stringListIterator.hasNext())
      System.out.println(stringListIterator.next());
      
    // Search in unsorted list
    boolean anotherSearch = true;
    String searchString;
    
    while (anotherSearch)
    {
      System.out.print("Enter a string to search for: ");
      searchString = keyboard.nextLine();
      int position = stringList.search(searchString);
      
      if (position != -1)
        System.out.println("String " + searchString
                            + " found at position " + position);
      else
        System.out.println("String " + searchString + " not in list");
    
      System.out.print("Search again? (Y/N)");
    
      String another = keyboard.nextLine();
      if (another.charAt(0) == 'Y' || another.charAt(0) == 'y')
        anotherSearch = true;
      else
        anotherSearch = false;
    } // while(anotherSearch)  
	  
	 // Sort and print in alphabetic order
	stringList.sort();

	System.out.println("\nThe names in alphabetic order:\n");
   stringListIterator = stringList.getIterator();
   
   while(stringListIterator.hasNext())
     System.out.println(stringListIterator.next().toString());

   // Search in unsorted list
   anotherSearch = true;
    
   while (anotherSearch)
   {
     System.out.print("Enter a string to search for: ");
     searchString = keyboard.nextLine();
     int position = stringList.search(searchString);
      
     if (position != -1)
       System.out.println("String " + searchString
                           + " found at position " + position);
     else
       System.out.println("String " + searchString + " not in list");
    
     System.out.print("Search again? (Y/N)");
     String another = keyboard.nextLine();
     if (another.charAt(0) == 'Y' || another.charAt(0) == 'y')
       anotherSearch = true;
     else
       anotherSearch = false;
   } // while(anotherSearch)  

  } // main
	
}
		 
	  