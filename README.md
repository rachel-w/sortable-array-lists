# sortable-array-lists
from CSIT212-Data Structures and Algorithms

Two Objectives:
1. Simulate a recursive method using a stack.  It should work with either an array implementation or a linked-list implementation of the Stack ADT.
2. Gain experience implementing an efficient sorting algorithm.

Prompt:
-Implement the Stack ADT efficiently using an array.To make it a bit interesting, make the stack grow from the end of the array instead of the beginning. 
-(length-1 or length-itemCount) should be the top to make this efficient.

-Implement the Stack ADT efficiently using a linked list.  Again, to make it a bit more interesting, use an empty head node (This is really not necessary for a stack, since we never remove any node except the first content node – the top of the stack.)
-Be sure to keep the head node empty.
-Create an abstractsubclass SortableArrayListWithStack of the abstract class SortableArrayList.
-In this class, override the recursive method binarySearch with a method that uses a stack of activation records to simulate the recursion.
-This class should have a new constructor that allows the caller to specify the type of stack. 
*Note that you will need to create an inner class ActivationRecord for the activation records for binary search.

-Create a new class SortableArrayListWithMergeSort or SortableArrayListWithQuickSort that extends your class SortableArrayListWithStack.
-This class should implement the method sortSubArray to use the appropriate sorting algorithm using recursion.

-Write a new driver that creates a SortableArrayListWith...Sort<Integer>.
-It should populate the list with random integers between 0 and 100 (using java.util.Random), print out the unsorted list and allow the user to search the unsorted list.
-It should then sort the list, print out the sorted list, and allow the user to search the sorted list.  You may, of course, use the driver I have provided as a model.

-Create a class SortableArrayListWithStackMergeSort or SortableArrayListWithStackQuickSort that uses a stack with appropriate activation records to simulate the recursion in Merge Sort or QuickSort.
-Write a modified driver that can be used to test your new class.

TESTING:
Be sure to test that it works for an item in the middle of the list, the item at the beginning of the list, the item at the end, and at least one item that is not in the list.
