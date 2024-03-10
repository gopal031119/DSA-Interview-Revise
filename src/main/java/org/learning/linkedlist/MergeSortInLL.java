package org.learning.linkedlist;

public class MergeSortInLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    public static void main(String args[]) {
        Node head = new Node(4);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        print(head);
        Node mergedLL = mergesort(head);
        print(mergedLL);
    }

    /**
     * 1. find LL Mid
     * 2. make mid.next=null, so we have left and right half
     * 3. sort and merge
     */
    private static Node mergesort(Node head) {
        
        if(head == null || head.next == null){
            return head;
        }
        Node mid = findMid(head);

        // preparing left and right
        Node left = head;
        Node right = mid.next;
        mid.next = null;

        Node newLeft = mergesort(left);
        Node newRight = mergesort(right);


        return merge(newLeft, newRight);
    }


    /**
     * 1. temporary LL with node -1
     * 2. compare left and right and move them to temporary ll
     */
    private static Node merge(Node leftHead, Node rightHead) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (rightHead != null && leftHead != null) {
            if (leftHead.data <= rightHead.data) {
                temp.next = leftHead;
                leftHead = leftHead.next;
                temp = temp.next;
            } else {
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
            }
        }
        while (leftHead != null) {
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
        }
        while (rightHead != null) {
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }
        return mergedLL.next; // removing -1 element
    }

    private static Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
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
