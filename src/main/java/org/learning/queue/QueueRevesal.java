package org.learning.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueRevesal {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // Example input queue
        for (int i = 1; i <= 5; i++) {
            q.add(i);
        }

        System.out.println("Original Queue: " + q);
        reverseQueue(q);
        System.out.println("Reversed Queue: " + q);
    }

    // Method to reverse the queue using a stack
    private static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Pop all elements from queue and push into stack
        while (!q.isEmpty()) {
            stack.push(q.remove());
        }

        // Step 2: Pop all elements from stack and add back into queue
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
    }
}

