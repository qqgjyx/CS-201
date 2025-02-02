public class ToDoList
{
   // Instance variable(s) [1 point]
   ... ...

   public ToDoList() // [2 point]
   {
      ... ...
   }

   public static void main(String[] args) // [10 points]
   {
      // Display a user instruction menu for various options
      ... ...

      /* Continuously ask for the user's input,
         such as adding new tasks, removing/printing the task,
         (the following methods 'addTask' and 'printTask' are called accoringly)
	 until a 'quit' option is given.
      */
      
      Scanner in = new Scanner(System.in);
      
      ... ...
   }
   
   // propmpt user to enter tasks and add to the queue [10 points]
   public void addTask()
   {
	// prompt user to continue entering a task (priority and description)
	// and add the task into the queue till 'Done' is entered by user
      	... ...     
       
   }

   // Get the next highest priority task and print it [5 point]
   // If no more task left, print 'No more tasks'.
   public void printTask()
   {
	... ...
   }
}