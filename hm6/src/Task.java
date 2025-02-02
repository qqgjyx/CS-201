// Define a class whose instances may be added into a priority queue
public class Task implements Comparable<Task>
{
   // add attributes [1 point]
   private int priority;
   private String description;

   public Task(int priority, String description) {
      this.priority = priority;
      this.description = description;
   }

   // add getters and setters [5 point]
   public int getPriority() {
      return priority;
   }

   public void setPriority(int priority) {
      this.priority = priority;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   // override a method defined in the interface this class implements
   // for being used for priority queue [5 point]
   @Override
   public int compareTo(Task other) {
      // Lower priority value means higher priority task
      return Integer.compare(this.priority, other.priority);
   }
}