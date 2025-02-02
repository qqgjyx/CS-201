public class MyLinkedList<E> {
    private static class MyNode<E> {
        E item;
        MyNode<E> next;

        MyNode(E element) {
            this.item = element;
            this.next = null;
        }
    }

    private MyNode<E> head;

    // Reverse elements in the list from position start to end
    public boolean reverse(int start, int end) throws Exception {
        if (start >= end || start < 0) {
            throw new IllegalArgumentException("Invalid start and end positions");
        }

        // Dummy node to simplify edge cases
        MyNode<E> dummy = new MyNode<E>(null);
        dummy.next = head;
        MyNode<E> prev = dummy;

        for (int i = 0; i < start; i++) {
            if (prev.next == null) {
                throw new Exception("Start position is out of bounds");
            }
            prev = prev.next;
        }

        MyNode<E> current = prev.next;
        MyNode<E> next;

        for (int i = start; i < end; i++) {
            if (current.next == null) {
                throw new Exception("End position is out of bounds");
            }
            next = current.next;
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        if (start == 0) {
            head = dummy.next;
        }

        return true;
    }

    // Add at the beginning for simplicity
    public void addFirst(E item) {
        MyNode<E> newNode = new MyNode<>(item);
        newNode.next = head;
        head = newNode;
    }

    // Print the list for testing
    public void printList() {
        MyNode<E> current = head;
        while (current != null) {
            if (current.next == null) {
                System.out.println(current.item);
                break;
            }
            System.out.print(current.item + " -> ");
            current = current.next;
        }
        //System.out.println("null");
    }

    // Test method
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addFirst("E");
        list.addFirst("D");
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");

        System.out.println("Original list:");
        list.printList();

        try {
            list.reverse(1, 3);
            System.out.println("Reversed list:");
            list.printList();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
