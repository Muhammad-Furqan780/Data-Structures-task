/**
 * Linked list with array.
 * Part 1: Node-based linked list that converts to/from an array.
 * Part 2: Linked list stored INSIDE arrays (data[] + next[]), no Node objects.
 */
public class LinkedListWithArray {

    // ---------- Part 1: Node-based list <-> array ----------
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    // Build a linked list from an array: O(n)
    static Node fromArray(int[] arr) {
        Node head = null, tail = null;
        for (int v : arr) {
            Node n = new Node(v);
            if (head == null) head = tail = n;
            else { tail.next = n; tail = n; }
        }
        return head;
    }

    // Copy a linked list into an array: O(n)
    static int[] toArray(Node head) {
        int size = 0;
        for (Node c = head; c != null; c = c.next) size++;
        int[] arr = new int[size];
        int i = 0;
        for (Node c = head; c != null; c = c.next) arr[i++] = c.data;
        return arr;
    }

    static void print(Node head) {
        for (; head != null; head = head.next)
            System.out.print(head.data + " -> ");
        System.out.println("NULL");
    }

    // ---------- Part 2: Linked list implemented using arrays ----------
    static class ArrayLinkedList {
        private final int[] data;
        private final int[] next;   // next[i] = index of the next node, -1 = end
        private int head = -1;      // index of first node
        private int free = 0;       // index of first free slot
        private final int capacity;

        ArrayLinkedList(int capacity) {
            this.capacity = capacity;
            data = new int[capacity];
            next = new int[capacity];
            // chain all slots into the free list
            for (int i = 0; i < capacity - 1; i++) next[i] = i + 1;
            next[capacity - 1] = -1;
        }

        // Insert at head: O(1)
        void insertHead(int val) {
            if (free == -1) { System.out.println("List is full"); return; }
            int slot = free;
            free = next[slot];
            data[slot] = val;
            next[slot] = head;
            head = slot;
        }

        // Delete first node with given value: O(n)
        void delete(int val) {
            int prev = -1, cur = head;
            while (cur != -1 && data[cur] != val) { prev = cur; cur = next[cur]; }
            if (cur == -1) { System.out.println(val + " not found"); return; }
            if (prev == -1) head = next[cur];
            else next[prev] = next[cur];
            next[cur] = free;       // return slot to the free list
            free = cur;
        }

        void print() {
            for (int c = head; c != -1; c = next[c])
                System.out.print(data[c] + " -> ");
            System.out.println("NULL");
        }
    }

    public static void main(String[] args) {
        System.out.println("== Array -> Linked list ==");
        Node head = fromArray(new int[]{10, 20, 30, 40});
        print(head);                         // 10 -> 20 -> 30 -> 40 -> NULL

        System.out.println("== Linked list -> Array ==");
        int[] arr = toArray(head);
        System.out.println(java.util.Arrays.toString(arr));   // [10, 20, 30, 40]

        System.out.println("== Linked list built inside arrays ==");
        ArrayLinkedList list = new ArrayLinkedList(5);
        list.insertHead(30);
        list.insertHead(20);
        list.insertHead(10);
        list.print();                        // 10 -> 20 -> 30 -> NULL
        list.delete(20);
        list.print();                        // 10 -> 30 -> NULL
        list.insertHead(5);
        list.print();                        // 5 -> 10 -> 30 -> NULL
    }
}
