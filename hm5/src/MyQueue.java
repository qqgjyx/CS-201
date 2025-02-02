import java.util.Stack;

public class MyQueue<E> {
    // define attributes required
    private Stack<E> inStack = new Stack<>();
    private Stack<E> outStack = new Stack<>();

    // add ‘e’ to the back of the queue
    public void enQueue(E e) {
        inStack.push(e);
    }
    // remove the element from the front of the queue and return it
    public E deQueue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
    // return the element at the front of the queue
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
    // return true if the queue is empty and not otherwise
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
    // test the methods above, print if necessary [5 points]
    public static void main(String[] str) {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);

        System.out.println("First element: " + queue.peek());
        System.out.println("Removed element: " + queue.deQueue());
        System.out.println("Next element: " + queue.peek());

        queue.enQueue(4);
        while (!queue.isEmpty()) {
            System.out.println("Dequeue: " + queue.deQueue());
        }
    }
}