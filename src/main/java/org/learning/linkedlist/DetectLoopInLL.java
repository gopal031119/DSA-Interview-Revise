package org.learning.linkedlist;

public class DetectLoopInLL {

    public static Node head;
    public static Node tail;
    public static int size;
    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static void main(String args[]){
        head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=head;

        System.out.println(detectLoop(head));
    }

    /**
     * floyd's cycle finding algorithm
     * T.C. = O(n+m) where n is total nodes and m is length of cycle \
     *
     * @param head
     * @return
     */
    private static boolean detectLoop(Node head){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast= fast.next.next;
            if(fast==slow){
                return true; // loop exist in LL
            }
        }
        return false;
    }
}
