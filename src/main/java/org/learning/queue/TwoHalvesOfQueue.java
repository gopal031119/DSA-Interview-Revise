package org.learning.queue;

import java.util.LinkedList;
import java.util.Queue;

public class TwoHalvesOfQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // Example input
        for (int i = 1; i <= 6; i++) {
            q.add(i);
        }

        System.out.println("Original Queue: " + q);
        interleaveQueue(q);
        System.out.println("Interleaved Queue: " + q);
    }

    private static void interleaveQueue(Queue<Integer> q) {
        // must be even number of elements
        if (q.size() % 2 != 0) {
            System.out.println("Queue length must be even!");
            return;
        }

        int halfSize = q.size() / 2;
        Queue<Integer> firstHalf = new LinkedList<>();

        // Step 1: Move first half into another queue
        for (int i = 0; i < halfSize; i++) {
            firstHalf.add(q.remove());
        }

        // Step 2: Interleave elements of firstHalf and secondHalf (remaining in q)
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }
}
