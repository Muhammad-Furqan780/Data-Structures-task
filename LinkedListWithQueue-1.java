/**
 * Linked list with queue.
 * A queue (FIFO) built on a singly linked list with head and tail pointers.
 * Enqueue at the tail, dequeue from the head, both O(1).
 */
public class LinkedListWithQueue {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static class Queue {
        private Node front;   // head: where we remove
        private Node rear;    // tail: where we add
        private int size;

        // Enqueue: add at tail, O(1)
        void enqueue(int val) {
            Node n = new Node(val);
            if (rear == null) front = rear = n;
            else { rear.next = n; rear = n; }
            size++;
        }

        // Dequeue: remove from head, O(1)
        int dequeue() {
            if (isEmpty()) throw new RuntimeException("Queue underflow");
            int val = front.data;
            front = front.next;
            if (front == null) rear = null;   // queue became empty
            size--;
            return val;
        }

        // Peek: read the front without removing, O(1)
        int peek() {
            if (isEmpty()) throw new RuntimeException("Queue is empty");
            return front.data;
        }

        boolean isEmpty() { return front == null; }

        int size() { return size; }

        void print() {
            System.out.print("FRONT -> ");
            for (Node c = front; c != null; c = c.next)
                System.out.print(c.data + " -> ");
            System.out.println("REAR");
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.print();                                    // FRONT -> 10 -> 20 -> 30 -> REAR

        System.out.println("Peek:    " + q.peek());      // 10
        System.out.println("Dequeue: " + q.dequeue());   // 10
        System.out.println("Dequeue: " + q.dequeue());   // 20
        q.print();                                    // FRONT -> 30 -> REAR

        q.enqueue(40);
        q.print();                                    // FRONT -> 30 -> 40 -> REAR
        System.out.println("Size: " + q.size());      // 2
    }
}
