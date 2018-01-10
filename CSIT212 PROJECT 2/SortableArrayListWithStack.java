/*
 *  abstract subclass SortableArrayListWithStack of the abstract class SortableArrayList. 
 *  Overrides the recursive method binarySearch with a method that uses a stack of activation records to simulate the recursion.  
 *  Has a new constructor that allows the caller to specify the type of stack. 
 *  Has inner class ActivationRecord for the activation records for binary search.
 *  
 *  Rachel Wey
 *  SortableArrayListWithStack.java
 */
public abstract class SortableArrayListWithStack<T extends Comparable<T>>
extends SortableArrayList <T>{
	
	private String stackType;

	public SortableArrayListWithStack(int capacity){
		super(capacity);
		this.stackType="A";
	}
	
	public SortableArrayListWithStack(String stackType){
		super();
		this.stackType=stackType;
	}

	
	public SortableArrayListWithStack() {
		
		super();
		this.stackType="A";
	}

	public int binarySearch(T value, int lowIndex, int highIndex){
		
		int currentPoint = 0;
		     /* currentPoint keeps track of the current point in
		         processing the recursive method that this method
		         simulates.  There are three code points:
		         
		         0 indicates the beginning of the recursive method
		         1 indicates the return point for the recursive call
		         2 indicates the return point to the original caller
		      */
		StackInterface<ActivationRecord> recordStack;
		    if (stackType == "A")
		       recordStack = new ArrayStack<ActivationRecord>(50);
		     else
		       recordStack = new LinkedStack<ActivationRecord>();
		    
		    
		    // Push first activation record onto stack
		    //return point 2
		    recordStack.push(new ActivationRecord(value, lowIndex, highIndex, 0));
		    ActivationRecord prevRecord, currentRecord;
		    
		    boolean done = false;
		    int returnValue = 0;
		    while (!done){
		    	currentRecord=recordStack.peek();
		    	switch(currentPoint){
		    	case 0: //starts simulation of recursive method
		    		if (currentRecord.getParamHighIndex()< currentRecord.paramLowIndex){
		    			// base case--ends simulated recursion
		    			currentPoint=currentRecord.getReturnPoint();
		    			return -1;
		    	
		    			
		    		}
		    		else{
		    			//simulate next recursive call
		    			//set the parameters
		    			T currentParamValue= currentRecord.getParamValue();
		    			int currentParamHighIndex=currentRecord.getParamHighIndex();
		    			int currentParamLowIndex=currentRecord.getParamLowIndex();
		    		
		    			
		    			currentRecord.setMidIndex((currentParamHighIndex+ currentParamLowIndex)/2); //Set midIndex
		    			int currentMidIndex=currentRecord.getMidIndex();
		    			currentRecord.setCompareValue(currentParamValue.compareTo(getItem(currentMidIndex))); //compare the two values
		    			int compareValue= currentRecord.getCompareValue();
		    	        
		    			if (compareValue==0){ //if found
		    				currentPoint=2;
		    				
		    			}
		    			else if (compareValue < 0){ 
		    				
		    			
		    			// Create new activation record [using return point 1 mentioned above]
		             	ActivationRecord newRecord= new ActivationRecord(currentParamValue, currentParamLowIndex,currentMidIndex-1,1);
						// The next iteration produces another recursive call. 
						//which means currentPoint should stay at 0 (unchanged)					
						recordStack.push(newRecord);
		    			}
		    			else{
		    				ActivationRecord newRecord = new ActivationRecord(currentParamValue, currentMidIndex+1,currentParamHighIndex,1);
		    				recordStack.push(newRecord);
		    			}
						
		    	
		    	}//else
		    	break;
		    		
		    	case 1:
		    		prevRecord=recordStack.pop();
		    		currentRecord=recordStack.peek();
		    		
		    		//pass on param values from prevRecord to currentRecord
		    		
		    		
		    		
		    		currentRecord.setParamValue(prevRecord.getParamValue());
		    		currentRecord.setParamLowIndex(prevRecord.getCompareValue());
		    		currentRecord.setParamHighIndex(prevRecord.getParamHighIndex());
		    		//new currentMidIndex
		    		T currentValue= currentRecord.getParamValue();
	    			int currentHighIndex=currentRecord.getParamHighIndex();
	    			int currentLowIndex=currentRecord.getParamLowIndex();
	    			int currentMidIndex=(currentLowIndex+currentHighIndex)/2;
	    			
	    			//compare 2 values
	    			int currentCompareValue=currentValue.compareTo(getItem(currentMidIndex));
	    			
	    			
	    			if (currentCompareValue==0){ //if found
	    				currentPoint=2;
	    			}
	    			else if(currentCompareValue < 0){ //value on left side
	    				ActivationRecord newRecord = new ActivationRecord(currentValue, currentLowIndex, currentMidIndex-1, 1);
	    				recordStack.push(newRecord);
	    			}
	    			else{ //CompareValue > 0 so the value is on the right side
	    				ActivationRecord newRecord = new ActivationRecord(currentValue, currentMidIndex+1, currentHighIndex, 1);
	    				recordStack.push(newRecord);
	    			}	
	    			
	    			
	    				
		    		
		    		break;
		    		
		    		
		    		
		    		
		    		
		    		
		    	case 2: //return from original call
		    		returnValue= currentRecord.getMidIndex();
		    		recordStack.pop();
		    		done=true;
		    		System.out.println("\nUsed Activation Records with " +stackType+ "\n");
		    		break;
		    }//switch
		    }//while  	
		    return returnValue;
		    }

	
	
	
	
	
	
	
	
	
	
	
	//Inner class for activation records
class ActivationRecord{
	private int paramLowIndex, // low index parameter
				 paramHighIndex, // high index parameter
				 localMidIndex, // local variable for middle index
				 localCompareValue; // local variable for comparing values
	
	private T paramValue; // parameter variable
	private int returnPoint; // points to the return after an activation record
	
	public ActivationRecord(T paramValue, int paramLowIndex, int paramHighIndex, int returnPoint){ 
		this.paramValue=paramValue; this.paramLowIndex=paramLowIndex; this.paramHighIndex=paramHighIndex; this.returnPoint=returnPoint;
	} 
	
	//getters and setters
	public int getReturnPoint()	 	{return returnPoint;}
	public T getParamValue() 		{return paramValue;}
	public int getParamLowIndex() 	{return paramLowIndex;}
	public int getParamHighIndex()  {return paramHighIndex;}
	public int getMidIndex() 		{return localMidIndex;}
	public int getCompareValue() 	{return localCompareValue;}
	
	public void setParamValue(T value)  			{this.paramValue=value;}
	public void setParamLowIndex(int lowIndex) 		{this.paramLowIndex=lowIndex;}
	public void setParamHighIndex(int highIndex)	{this.paramHighIndex=highIndex;}
	public void setReturnPoint(int returnPoint)		{this.returnPoint=returnPoint;}
	public void setMidIndex(int midIndex) 			{localMidIndex=midIndex;}
	public void setCompareValue(int compareValue) 	{localCompareValue=compareValue;}
	
}
	
	

}
 