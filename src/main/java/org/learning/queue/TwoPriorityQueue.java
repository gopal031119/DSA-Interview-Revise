package org.learning.queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class TwoPriorityQueue {
    public static void main(String[] args) {

        // 1️⃣ Default PriorityQueue (Min-Heap)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Natural order (smallest first)
        minHeap.add(50);
        minHeap.add(10);
        minHeap.add(30);
        minHeap.add(20);
        minHeap.add(40);

        System.out.println("Default PriorityQueue (Min-Heap):");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " "); // removes smallest element first
        }

        // 2️⃣ Custom PriorityQueue (Max-Heap using Collections.reverseOrder)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(50);
        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(20);
        maxHeap.add(40);

        System.out.println("\n\nCustom PriorityQueue (Max-Heap):");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " "); // removes largest element first
        }
    }
}
