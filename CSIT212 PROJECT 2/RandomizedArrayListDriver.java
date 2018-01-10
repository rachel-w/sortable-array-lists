/*
 * A driver that fills an array with random numbers.
 * Allows user to choose Array or Linked List 
 * Prints the unsorted and sorted lists and allows the user to search them.
 * Rachel Wey
 * RandomizedArrayListDriver.java
 */

import java.util.*;


class RandomizedArrayListDriver
{
  @SuppressWarnings("resource")
public static void main(String args[])
  {  
     
	 // Set up scanner for keyboard input 
	 Scanner keyboard = new Scanner(System.in);
	 Random randomNum = new Random();// set up random generator 
	 System.out.println("Enter desired amount of numbers:");
	 int numOfInts=Integer.parseInt(keyboard.nextLine());
	 
	
	 //Decide which stack type to use
	 System.out.println("Select a Stack. Enter A for array or L for linked list:");
	 String stackType=keyboard.nextLine();
	 
	 
	 System.out.println("Unsorted random numbers:");

	 
	 SortableArrayList<Integer> integerList
         = new SortableArrayListWithQuickSort<Integer>(stackType);
									 	  
	 
	 
	 
	 
	 //load random numbers (integers) into the list
	 for (int i =0; i < numOfInts; i++ ){
		 integerList.append(randomNum.nextInt(100)+1);
	 }
	  
	 
	 
	 // Print original list
	 System.out.println("\nThe original list:\n");
    Iterator<Integer> integerListIterator = integerList.getIterator();
    
    while(integerListIterator.hasNext())
      System.out.println(integerListIterator.next());
      
    // Search in unsorted list
    boolean anotherSearch = true;
    int searchInt;
    
  
    while (anotherSearch)
    {
      System.out.print("Enter a number to search for it: ");
      searchInt = Integer.parseInt(keyboard.nextLine());
      int position = integerList.search(searchInt);
      
      if (position != -1){
        System.out.println("This integer is " + searchInt
                            + " found at position " + position);
      }
      else{
        System.out.println("The number " + searchInt + " is not in the list");
      }// if
      
      System.out.print("Search again? (Y/N)");
      String another = keyboard.nextLine();
      if (another.charAt(0) == 'Y' || another.charAt(0) == 'y')
        anotherSearch = true;
      else
        anotherSearch = false;
    } // while(anotherSearch)  
	  
	 // Sort and print in order
	integerList.sort();

	System.out.println("\nThe sorted list of numbers:\n");
   integerListIterator = integerList.getIterator();
   
   while(integerListIterator.hasNext())
     System.out.println(integerListIterator.next().toString());

   // Search in sorted list
   anotherSearch = true;
    
   while (anotherSearch)
   {
     System.out.print("Enter an integer to search for it: ");
     searchInt = Integer.parseInt(keyboard.nextLine());
     int position = integerList.search(searchInt);
      
     if (position != -1)
       System.out.println("The number " + searchInt
                           + " is found at position " + position);
     else
       System.out.println("Integer " + searchInt + " is not in the list");
    
     System.out.print("Search again? (Y/N)");
    
     String another = keyboard.nextLine();
     if (another.charAt(0) == 'Y' || another.charAt(0) == 'y')
       anotherSearch = true;
     else
       anotherSearch = false;
   } // while 

  } // main
	
}
		 
	  