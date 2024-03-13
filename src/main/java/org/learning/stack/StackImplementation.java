package org.learning.stack;

import java.util.ArrayList;

public class StackImplementation {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.isEmpty();
        }

        public static void push(int data) {
            list.add(data);
        }

        public static int peek() {

            if (isEmpty()) {
                System.out.println("stack is empty");
                return -1;
            }

            return list.get(list.size() - 1);
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("stack is empty");
                return -1;
            }
            return list.remove(list.size() - 1);
        }
    }

    public static void main(String... args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}
