package org.learning.linkedlist;

public class LinkedList {
    public static Node head;
    public static Node tail;
    public static int size;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static void main(String args[]) {
        LinkedList linkedList = new LinkedList();
        addFirst(3);
        addFirst(2);
        addFirst(1);
        addLast(4);
        addInMiddle(3, 11);
        addLast(5);
        printLinkedList();
        System.out.println("Size of linked list: " + size);
        System.out.println("Removed first element: " + removeFirst());
        System.out.println("Removed last element: " + removeLast());
        printLinkedList();
        System.out.println("element found at index: " + search(11));
        reverseLinkedList();
        printLinkedList();
        removeNthFromLast(4);
        printLinkedList();
        System.out.println("is it palindrome: " + isPalindrome());
    }

    /**
     * 1. create new node
     * 2. new node's next = head
     * 3. head = new node
     * Time Complexity - O(1)
     *
     * @param data
     */
    private static void addFirst(int data) {
        size++;
        Node newNode = new Node(data);

        // for base case
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    /**
     * 1. create new node
     * 2. tail.next = newNode
     * 3. tail = new node
     * Time Complexity - O(1)
     *
     * @param data
     */
    private static void addLast(int data) {
        size++;
        Node newNode = new Node(data);
        // for base case
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    /**
     * Time Complexity - O(n)
     */
    private static void printLinkedList() {
        Node temp = head;

        // base case
        if (head == null) {
            System.out.println("Linked List is Empty..");
        }
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    /**
     * Time Complexity - O(n)
     */
    private static void addInMiddle(int index, int data) {
        // base case
        if (index == 0) {
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        while (index - 1 != 0) {
            temp = temp.next;
            index--;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    /**
     * Time Complexity - O(1)
     *
     * @return
     */
    private static int removeFirst() {
        if (size == 0) {
            System.out.println("Nothing to delete, list is empty");
            return -1;
        } else if (size == 1) {
            //case when head and tail are equal
            int data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    /**
     * 1.prev node :- iterate it to the second last element
     * 2.prev.next=null
     * 3.tail=prev
     * <p>
     * Time Complexity - O(n)
     */
    private static int removeLast() {
        if (size == 0) {
            System.out.println("Nothing to delete, list is empty");
            return -1;
        } else if (size == 1) {
            //case when head and tail are equal
            int data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }
        Node prev = head;
        //prev = size-2
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int data = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return data;
    }

    /**
     * Time Complexity - O(n)
     *
     * @param val
     * @return
     */
    private static int search(int val) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data == val) {
                return i + 1;
            }
            temp = temp.next;
        }
        return -1;
    }

    /**
     * prev, curr, next
     * next=curr.next
     * curr.next = prev
     * prev=curr
     * curr= next
     * Time Complexity - O(n)
     *
     * @return
     */
    private static void reverseLinkedList() {
        Node prev, curr, next;
        prev = null;
        curr = tail = head; // assigning right to left in java
        next = curr.next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    /**
     * Time complexity  O(n)
     *
     * @param n
     */
    private static void removeNthFromLast(int n) {
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if (n == sz) {
            head = head.next;
            return;
        }

        int i = 1;
        int index = sz - n;
        Node prev = head;
        while (i < index) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }

    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 1. first mid-element
     * 2. 2nd half reverse
     * 3. check if 1st half = 2nd half
     *
     * Time complexity - O(n)
     */
    private static boolean isPalindrome() {

        //base case
        if (head == null || head.next == null) {
            return true;
        }

        // step 1 find mid
        Node mid = findMid(head);

        // step 2 Reverse 2nd half
        Node prev = null;
        Node curr = mid;
        Node next = curr.next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // step 3
        Node right = prev;
        Node left = head;

        while (right != null) {
            if (right.data != left.data)
                return false;
            right = right.next;
            left = left.next;
        }

        return true;
    }

}
