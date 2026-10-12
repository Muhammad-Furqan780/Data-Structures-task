/**
 * Linked list with stack.
 * A stack (LIFO) built on a singly linked list.
 * The head of the list is the top of the stack, so push/pop are O(1).
 */
public class LinkedListWithStack {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static class Stack {
        private Node top;   // head of the linked list
        private int size;

        // Push: add at head, O(1)
        void push(int val) {
            Node n = new Node(val);
            n.next = top;
            top = n;
            size++;
        }

        // Pop: remove from head, O(1)
        int pop() {
            if (isEmpty()) throw new RuntimeException("Stack underflow");
            int val = top.data;
            top = top.next;
            size--;
            return val;
        }

        // Peek: read the top without removing, O(1)
        int peek() {
            if (isEmpty()) throw new RuntimeException("Stack is empty");
            return top.data;
        }

        boolean isEmpty() { return top == null; }

        int size() { return size; }

        void print() {
            System.out.print("TOP -> ");
            for (Node c = top; c != null; c = c.next)
                System.out.print(c.data + " -> ");
            System.out.println("NULL");
        }
    }

    // Bonus: classic use of a stack, reversing a string
    static String reverse(String s) {
        Stack st = new Stack();
        for (char ch : s.toCharArray()) st.push(ch);
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append((char) st.pop());
        return sb.toString();
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.print();                                   // TOP -> 30 -> 20 -> 10 -> NULL

        System.out.println("Peek: " + s.peek());     // 30
        System.out.println("Pop:  " + s.pop());      // 30
        System.out.println("Pop:  " + s.pop());      // 20
        s.print();                                   // TOP -> 10 -> NULL
        System.out.println("Size: " + s.size());     // 1

        System.out.println("Reverse \"hello\": " + reverse("hello"));  // olleh
    }
}
