package org.learning.queue;

import java.util.Stack;

public class QueueUsing2Stack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsing2Stack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation (O(1))
    public void enqueue(int data) {
        stack1.push(data);
        System.out.println(data + " enqueued to queue");
    }

    // Dequeue operation (O(n) worst case)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1;
        }

        // If stack2 is empty, move all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    // Peek the front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Get the size of the queue
    public int size() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {
        QueueUsing2Stack queue = new QueueUsing2Stack();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        queue.enqueue(40);
        System.out.println("Front element: " + queue.peek());

        System.out.println("Queue size: " + queue.size());
    }
}
