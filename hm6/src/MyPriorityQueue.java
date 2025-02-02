public class MyPriorityQueue<E>
{
   Node<E> front; // reference to the first node in the queue

   public MyPriorityQueue() // [1 point]
   {
      front = null;
   }

   // add an item E into the queue (according to its priority)
   public void push (Node<E> node) // [10 point]
   {
      if (front == null || node.priority > front.priority) {
         node.next = front;
         front = node;
      } else {
         Node<E> current = front;
         while (current.next != null && current.next.priority >= node.priority) {
            current = current.next;
         }
         node.next = current.next;
         current.next = node;
      }
   }

   // pop up the time (with the highest priority from the queue
   // throw an exception if the queue is empty
   public Node<E> pop() // [2 point]
   {
      if (front == null) throw new RuntimeException("Queue is empty");
      Node<E> tempNode = front;
      front = front.next;
      return tempNode;
   }

   // display/print all the items in the queue
   // print a message if the queue is empty
   public void display() // [2 point]
   {
      if (front == null) {
         System.out.println("Queue is empty");
         return;
      }
      Node<E> temp = front;
      while (temp != null) {
         System.out.println(temp.item + " (Priority: " + temp.priority + ")");
         temp = temp.next;
      }
   }

   public static void main(String[] args) // [5 points]
   {
      // create an instance of MyPriorityQueue<E>
      MyPriorityQueue<String> stringQueue = new MyPriorityQueue<>();

      // add no less than 5 String (or int, float) to the queue
      stringQueue.push(new Node<>("Apple", 5));
      stringQueue.push(new Node<>("Banana", 2));
      stringQueue.push(new Node<>("Cherry", 7));
      stringQueue.push(new Node<>("Date", 4));
      stringQueue.push(new Node<>("Elderberry", 6));

      // display the contents of queue to test it
      System.out.println("Queue after adding strings:");
      stringQueue.display();

      // pop up one element from the queue and display again
      stringQueue.pop();
      System.out.println("\nQueue after popping one string:");
      stringQueue.display();

      // Create an instance of MyPriorityQueue for MyItem objects
      MyPriorityQueue<MyItem> itemQueue = new MyPriorityQueue<>();
      // add no less than 5 instances of your own defined class
      itemQueue.push(new Node<>(new MyItem("Item1", 100), 3));
      itemQueue.push(new Node<>(new MyItem("Item2", 200), 1));
      itemQueue.push(new Node<>(new MyItem("Item3", 300), 5));
      itemQueue.push(new Node<>(new MyItem("Item4", 400), 4));
      itemQueue.push(new Node<>(new MyItem("Item5", 500), 2));
      // display the contents of queue to test it
      System.out.println("\nQueue after adding MyItem objects:");
      itemQueue.display();
      // pop up one element from the queue and display again
      itemQueue.pop();
      System.out.println("\nQueue after popping one MyItem object:");
      itemQueue.display();
   }

   // complete the node class [5 points]
   static class Node<E>
   {
      // add attributes so that it's used for a linked list
      // add a constructor (and other methods if needed)
      E item;
      int priority;
      Node<E> next;

      Node(E item, int priority) {
         this.item = item;
         this.priority = priority;
         this.next = null;
      }

   }

   // define your own class [3 points]
   // whose instances will be added into the queue
   static class MyItem
   {
      // add attributes or methods needed
      String name;
      int value; // Example attributes

      MyItem(String name, int value) {
         this.name = name;
         this.value = value;
      }

      @Override
      public String toString() {
         return "MyItem{" + "name='" + name + '\'' + ", value=" + value + '}';
      }
   }
}