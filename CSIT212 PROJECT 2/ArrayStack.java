/*
 *An implementation of a Stack using an array
 *Rachel Wey
 *ArrayStack.java
 */

class ArrayStack<T> implements StackInterface<T>
{
	private T[] stack;

    private int head, totalCapacity;
    private static final int DEFAULT_CAPACITY = 50;

    // Constructor that uses given capacity
   @SuppressWarnings("unchecked")
public ArrayStack(int capacity){
        stack = (T[]) new Object[capacity];
        totalCapacity = capacity;
        head = capacity;
    }

   // Constructor
    public ArrayStack(){
        this(DEFAULT_CAPACITY);
    }


    // Push new entry onto head
    
     @Override
     public void push(T newEntry) {
        if(head == 0) { // If array is full
           
            // create a new array with doube the capacity
            int newCapacity = totalCapacity*2;
            T[] tempArray = (T[]) new Object[newCapacity];
            
            // copies the array into the new one
            for(int i = 0; i < totalCapacity; ++i){
                tempArray[i] = stack[i];
            }
            // larger array takes over
            stack = tempArray;
           
            // Moves the array contents to the right-hand side.
            for (int i = 0; i < totalCapacity; ++i){
                tempArray[i+totalCapacity] = tempArray[i];
            }
            //head becomes next index in the bigger array
            head = totalCapacity;

            // capcity reset
            totalCapacity = newCapacity;
        }
        --head; //brings the head to the left
        stack[head] = newEntry; //New entry at whichever index head is at in stack
    }

    @Override
    public T pop() {
        //makes sure stack is not empty before removing item
        if(isEmpty()){
            return null;
        }
        // removes item at head location, then moves head over
        T toReturn;
        toReturn = stack[head];
        ++head;

        return toReturn;//removed item
    }

    @Override
    public T peek() {  //returns item at head's index
        
        //Checks if stack is empty
        if(isEmpty()){
            return null;
        }

        return stack[head]; //Returns item
    }

    @Override
    public boolean isEmpty() {
        return head == totalCapacity;
    }

    @Override
    public void clear() {
        //clears out stack
        for(int i = 0; i < totalCapacity; ++i){
            stack[i] = null;
        }
        //head moved
        head = totalCapacity;
    }

    public static void main(String... args){
        ArrayStack<String> ourStack = new ArrayStack<String>();
        for(int i = 0; i < 200; ++i){
            ourStack.push(""+i);
        }
        System.out.println(" Filled the Stack ");
        System.out.println(" Pop: " + ourStack.pop());
        System.out.println(" Peek: " + ourStack.peek());
        ourStack.clear();
        System.out.println(" Cleared the Stack ");
        System.out.println(" Is Empty?: "+ ourStack.isEmpty() );

    }
}
