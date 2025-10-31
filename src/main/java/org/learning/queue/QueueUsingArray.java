package org.learning.queue;

public class QueueUsingArray {
    private int[] arr;     // Array to store queue elements
    private int front;     // Points to the first element
    private int rear;      // Points to the last element
    private int capacity;  // Maximum capacity of the queue

    // Constructor
    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;

        rear = -1;
    }

    // Enqueue (add element at the end)
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue " + data);
            return;
        }
        rear++;
        arr[rear] = data;
        System.out.println(data + " enqueued to queue.");
    }

    // Dequeue (remove element from front)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1;
        }
        int data = arr[front];
        front++;
        return data;
    }

    // Peek (view the front element)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[front];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front > rear;
    }

    // Check if queue is full
    public boolean isFull() {
        return rear == capacity - 1;
    }

    // Display all elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front element: " + queue.peek());


        queue.enqueue(60);
        queue.display();

        // This will fail because the queue is full (rear = capacity - 1)
        queue.enqueue(70);
    }
}
