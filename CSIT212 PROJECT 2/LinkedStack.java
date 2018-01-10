/*LinkedStack.java
 * Author: Rachel Wey
 * a stack that uses a linked list where the head node remains empty
 *
 */
class LinkedStack<T> implements StackInterface<T>
{
  // Inner class Node
   class Node
   {
     private T item;
     private Node next;
     
     public Node(T item, Node next) {
        this.item = item;
        this.next = next;
     }
     
    //get and set methods
     public void setItem(T item)    {this.item = item;}
     public void setNext(Node next) {this.next = next;}
     public T getItem()             {return item;}
     public Node getNext()          {return next;}
  }

  private Node headNode = new Node(null, null); // dummy head
  private int size;
 
   // Reference to node containing top item (first node in linked list)  
  
 // Constructor
  public LinkedStack()
  {
    headNode = null;
  }
     
 // Pushes item onto top   
  public void push (T item)
  {
	  headNode.next = new Node(item, headNode.next);
	    size++;
  }
  
 // Pops and returns top item
 // Returns null if stack is empty
  public T pop ()
  {
	  if (size == 0) throw new IllegalStateException("the list is empty");

	    T item = headNode.next.item;
	    headNode.next = headNode.next.next;
	    size--;
	    return item;
    }
  
  
 // Returns top item, or null if stack is empty 
  public T peek()
  {
    if(isEmpty())
      return null;
    else
      return headNode.next.item;
    
  }
  
 // Returns true iff stack is empty 
  public boolean isEmpty()
  {
    return size==0;
  }
  
 // Removes all items from stack
  public void clear()
  {
    headNode.next = null;
    // Turns rest of list into garbage
    
  
      }
  }
