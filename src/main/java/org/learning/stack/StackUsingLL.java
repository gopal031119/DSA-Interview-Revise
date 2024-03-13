package org.learning.stack;

public class StackUsingLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class stack {
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            Node newNode = new Node(data);

            if (isEmpty()) {
                head = new Node(data);
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public static int pop() {

            if (isEmpty()) {
                return -1;
            }

            int val = head.data;
            head = head.next;
            return val;
        }

        public static int peek() {

            if (isEmpty()) {
                return -1;
            }

            return head.data;
        }
    }
    
    public static void main(String... args) {
        StackImplementation.Stack s = new StackImplementation.Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}
