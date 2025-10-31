package org.learning.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queue {
    private Queue<Integer> q1 = new LinkedList<>();  // main queue
    private Queue<Integer> q2 = new LinkedList<>();  // helper queue

    // Push element onto stack (O(n))
    public void push(int x) {
        // Step 1: Enqueue new element into q2
        q2.add(x);

        // Step 2: Move all elements from q1 -> q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Step 3: Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop element from stack (O(1))
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return q1.remove();
    }

    // Peek top element of stack (O(1))
    public int top() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.peek();
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    // Print current stack (top to bottom)
    public void printStack() {
        System.out.println("Stack (top→bottom): " + q1);
    }

    // Test the stack
    public static void main(String[] args) {
        StackUsing2Queue stack = new StackUsing2Queue();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printStack();  // Output: [3, 2, 1]

        stack.push(4);
        stack.printStack();  // Output: [4, 3, 2, 1]

        System.out.println("Top element: " + stack.top());  // Output: 4

        System.out.println("Popped: " + stack.pop());  // Output: 4
        stack.printStack();  // Output: [3, 2, 1]
    }
}

