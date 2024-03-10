package org.learning.linkedlist;

public class DeleteLoopInLL {

    public static Node head;
    static class Node{
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
        head.next.next.next=head.next;
        System.out.println(detectLoop(head));
        removeLoopInLL(head);
        System.out.println(detectLoop(head));

    }

    /**
     * 1. detect loop
     * 2. set slow=head
     * 3. define prev=null
     * 4. prev=fast, slow+1, fast+1 until slow == fast
     * 5. prev.next=null
     *
     * @param head
     */
    private static void removeLoopInLL(Node head){
       Node slow = head;
       Node fast = head;
       boolean isCycleExist = false;
       while(fast != null && fast.next!=null){
           slow=slow.next;
           fast=fast.next.next;
           if(fast==slow){
               isCycleExist =true ;
               break;
           }
       }

       if(isCycleExist == false){
           return;
       }

       slow=head;
        Node prev= null;

       while(slow!=fast){
           prev=fast;
           slow=slow.next;
           fast=fast.next;
       }

       // to remove cycle , make prev.next as null
       prev.next=null;
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
