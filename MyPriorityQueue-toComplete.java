public class MyPriorityQueue<E>
{
   Node<E> front; // reference to the first node in the queue

   public MyPriorityQueue() // [1 point]
   {
      ... ...
   }

   // add an item E into the queue (according to its priority)
   public void push (Node<E> node) // [10 point]
   {
      ... ...
   }

   // pop up the time (with the highest priority from the queue
   // throw an exception if the queue is empty
   public Node<E> pop() // [2 point]
   {
      ... ...
   }

   // display/print all the items in the queue
   // print a message if the queue is empty
   public void display() // [2 point]
   {
      ... ...
   }

   public static void main(String[] args) // [5 points]
   {
      // create an instance of MyPriorityQueue<E>
      
      // add no less than 5 String (or int, float) to the queue
      // display the contents of queue to test it
      // pop up one element from the queue and display again

      // add no less than 5 instances of your own defined class
      // display the contents of queue to test it
      // pop up one element from the queue and display again

   }
   
   // complete the node class [5 points]
   static class Node<E>()
   {
	// add attributes so that it's used for a linked list
	// add a constructor (and other methods if needed)
       
   }

   // define your own class [3 points]
   // whose instances will be added into the queue
   static class YOURCLASS
   {
	// add attributes or methods needed
   }
}