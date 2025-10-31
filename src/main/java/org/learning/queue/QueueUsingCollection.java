package org.learning.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingCollection {

    public static void main(String[] args) {
        // Create a Queue using LinkedList
        Queue<Integer> queue = new LinkedList<>();

        // Enqueue elements (add elements to the queue)
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Queue after enqueuing elements: " + queue);

        // Peek (retrieve front element without removing)
        System.out.println("Front element (peek): " + queue.peek());

        // Dequeue (remove element from the front)
        int removed = queue.remove(); // or queue.poll()
        System.out.println("Dequeued element: " + removed);

        // Display the queue after dequeue
        System.out.println("Queue after dequeue: " + queue);

        // Check size
        System.out.println("Current queue size: " + queue.size());

        // Check if queue is empty
        System.out.println("Is the queue empty? " + queue.isEmpty());
    }
}

