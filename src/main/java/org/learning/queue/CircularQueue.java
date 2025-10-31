package org.learning.queue;

public class CircularQueue {
    private int[] arr;     // array to store elements
    private int size;      // current number of elements
    private int front;     // index of the front element
    private int rear;      // index of the rear element
    private int capacity;  // maximum capacity of the queue

    // Constructor
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        size = 0;
        front = 0;
        rear = -1;
    }

    // Enqueue (add element at the end)
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue " + data);
            return;
        }
        rear = (rear + 1) % capacity; // circular increment
        arr[rear] = data;
        size++;
        System.out.println(data + " enqueued to queue.");
    }

    // Dequeue (remove element from the front)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1;
        }
        int data = arr[front];
        front = (front + 1) % capacity; // circular increment
        size--;
        return data;
    }

    // Peek (front element)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[front];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Display all elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.display();

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front element: " + queue.peek());

        queue.enqueue(50);
        queue.enqueue(60);
        queue.display();

        queue.enqueue(70); // should show "Queue is full"
    }
}
