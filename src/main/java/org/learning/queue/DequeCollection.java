package org.learning.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeCollection {
    public static void main(String[] args) {
        // Create a Deque using ArrayDeque (most common implementation)
        Deque<Integer> deque = new ArrayDeque<>();

        // Add elements at both ends
        deque.addFirst(10);
        deque.addLast(20);
        deque.addLast(30);
        deque.addFirst(5);

        System.out.println("Initial Deque: " + deque);

        // Access elements
        System.out.println("First Element: " + deque.getFirst());
        System.out.println("Last Element: " + deque.getLast());

        // Remove elements from both ends
        deque.removeFirst();
        deque.removeLast();

        System.out.println("After Removals: " + deque);

        // Using Deque as a stack
        deque.push(40);  // same as addFirst()
        deque.push(50);
        System.out.println("As Stack (push): " + deque);

        deque.pop(); // removes from front
        System.out.println("After pop(): " + deque);
    }
}
