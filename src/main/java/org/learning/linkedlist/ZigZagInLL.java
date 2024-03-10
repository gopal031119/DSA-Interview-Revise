package org.learning.linkedlist;

public class ZigZagInLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String... args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        print(head);
        print(zigzagLL(head));
    }

    /**
     * 1. find mid ... have left half and right half
     * 2. reverse right half (when you want to travel backward in singly linked list, only way is to reverse it)
     * 3. alternate merging
     */
    private static Node zigzagLL(Node head) {
        Node mid = findMid(head);
        Node leftHead = head;
        Node right = mid.next;
        mid.next = null;

        Node rightHead = reverse(right);

        Node mergeNode = mergeLLInZigZac(leftHead, rightHead);
        return mergeNode;
    }

    private static Node mergeLLInZigZac(Node leftHead, Node rightHead) {
        Node nextLeft;
        Node nextRight;
        Node mergeNode = leftHead;

        while (leftHead != null && rightHead != null) {

            //zigzag
            nextLeft = leftHead.next;
            leftHead.next = rightHead;
            nextRight = rightHead.next;
            rightHead.next = nextLeft;

            // update
            leftHead = nextLeft;
            rightHead = nextRight;
        }
        return mergeNode;
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = head.next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    private static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
}

