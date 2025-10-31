package org.learning.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackAndQueueUsingDeque {
    public static void main(String[] args) {
        // Create a Deque
        Deque<Integer> deque = new ArrayDeque<>();

        // === Stack Operations (LIFO) ===
        System.out.println("=== Stack using Deque ===");
        deque.push(10); // push = addFirst()
        deque.push(20);
        deque.push(30);
        System.out.println("Stack (top -> bottom): " + deque);

        System.out.println("Top Element: " + deque.peek()); // peek = getFirst()
        System.out.println("Popped: " + deque.pop());       // pop = removeFirst()
        System.out.println("After pop: " + deque);

        // Clear deque for next example
        deque.clear();

        // === Queue Operations (FIFO) ===
        System.out.println("\n=== Queue using Deque ===");
        deque.offer(10);  // offer = addLast()
        deque.offer(20);
        deque.offer(30);
        System.out.println("Queue (front -> rear): " + deque);

        System.out.println("Front Element: " + deque.peek());   // peek = getFirst()
        System.out.println("Dequeued: " + deque.poll());        // poll = removeFirst()
        System.out.println("After dequeue: " + deque);
    }
}
