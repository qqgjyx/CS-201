import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ToDoList
{
   // Instance variable(s) [1 point]
   private final PriorityQueue<Task> taskQueue;

   public ToDoList() // [2 point]
   {
      taskQueue = new PriorityQueue<>();
   }

   public static void main(String[] args) // [10 points]
   {
      // Display a user instruction menu for various options
      System.out.println("Select an option: \n1. Add a task\n2. Show next task\n3. Quit");

      /* Continuously ask for the user's input,
         such as adding new tasks, removing/printing the task,
         (the following methods 'addTask' and 'printTask' are called accordingly)
	 until a 'quit' option is given.
      */
      Scanner in = new Scanner(System.in);
      ToDoList toDoList = new ToDoList();

      while (true) {
         String option = in.nextLine();
         switch (option) {
            case "1":
               toDoList.addTask();
               break;
            case "2":
               toDoList.printTask();
               break;
            case "3":
               System.out.println("Exiting program.");
               return;
            default:
               System.out.println("Invalid option. Please try again.");
               break;
         }
      }
   }
   
   // prompt user to enter tasks and add to the queue [10 points]
   public void addTask() {
	// prompt user to continue entering a task (priority and description)
	// and add the task into the queue till 'Done' is entered by user
      Scanner in = new Scanner(System.in);
      System.out.println("Enter a task in 'priority description' format (or 'Done' to finish):");

      while (in.hasNextLine()) {
         String input = in.nextLine();
         if (input.equalsIgnoreCase("Done")) {
            break;
         }

         String[] parts = input.split(" ", 2);
         if (parts.length < 2) {
            System.out.println("Invalid format. Please use 'priority description' format.");
            continue;
         }

         try {
            int priority = Integer.parseInt(parts[0]);
            if (priority<1 || priority>9) throw new InputMismatchException("Priority out of range");
            String description = parts[1];
            Task newTask = new Task(priority, description);
            taskQueue.offer(newTask);

            //TODO: implement the hind for task recorded to improve user interaction
//            System.out.println("Task recorded enter another or 'Done' to finish):");

         } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Invalid priority. Please enter a valid number.");
         }
      }
   }

   // Get the next highest priority task and print it [5 point]
   // If no more task left, print 'No more tasks'.
   public void printTask() {
      if (taskQueue.isEmpty()) {
         System.out.println("No more tasks.");
      } else {
         Task task = taskQueue.poll();
         System.out.println("Next task: " +task.getPriority()+" "+ task.getDescription());
      }
   }
}