package org.learning.linkedlist;

public class DoublyLL {
    public static Node head;
    public static Node tail;
    public static int size;

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static void main(String args[]) {
        addFirst(3);
        addFirst(2);
        addFirst(1);
        addLast(4);
        addLast(5);
        print();
        removeFirst();
        print();
        removeLast();
        print();
    }

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public static void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public static int removeFirst() {

        if (head == null) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }

        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public static void removeLast() {

        if (head == null) {
            System.out.println("ll is empty");
            return;
        }

        if (size == 1) {
            head = tail = null;
            size--;
            return;
        }

        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public static void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
