
/*
 * SortableArrayListWithQuickSortt that extends SortableArrayListWithStack.
 * Implements sortSubArray to use quicksort recursively.
 * 
 * Rachel Wey
 * SortableArrayListWithQuickSort.java
 */
class SortableArrayListWithQuickSort<T extends Comparable<T>> 
extends SortableArrayListWithStack <T>
{




	public SortableArrayListWithQuickSort(int capacity){
		super(capacity);
	}



	public SortableArrayListWithQuickSort(){
		super();

	}


		public SortableArrayListWithQuickSort(String stackType) {
		// TODO Auto-generated constructor stub
			super(stackType);
			
	}



		/**
	     * @param  num  an array of numbers in any order
	     * @return      a sorted array of the same numbers
	     **/
	
		protected void sortSubArray(T[] listItems,int lowIndex, int highIndex) {	

	             
	    	        int i = lowIndex;
	    	        int j = highIndex;
	    	        // calculate pivot number (middle index)
	    	        T pivot = listItems[lowIndex+(highIndex-lowIndex)/2];
	    	        // Divide into two arrays
	    	        while (i <= j) {
	    	            /**
	    	             * each iteration:
	    	             * identifies number from left side that is greater then the pivot value
	    	             * identifies a number from the right side that is less then the pivot value
	    	             * exchanges both numbers when search is done
	    	             */
	    	            while (listItems[i].compareTo(pivot) < 0) {
	    	                i++;
	    	            }
	    	            while (listItems[j].compareTo(pivot) >0) {
	    	                j--;
	    	            }
	    	            if (i <= j) {
	    	                exchangeNumbers(listItems,i, j);
	    	                //move index to next position for both sides of pivot
	    	                i++;
	    	                j--;
	    	            }
	    	        }
	    	        // recursive calls to quickSort()
	    	        if (lowIndex < j)
	    	            sortSubArray(listItems, lowIndex, j);
	    	        if (i < highIndex)
	    	            sortSubArray(listItems, i, highIndex);
	    	    }
	    	 
	    	    private void exchangeNumbers(T[] listItems,int i, int j) {
	    	        T temp = listItems[i];
	    	        listItems[i] = listItems[j];
	    	        listItems[j] = temp;
	    	    }
	    	}


	    

	