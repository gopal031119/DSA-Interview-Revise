package org.learning.linkedlist;

import static org.learning.linkedlist.DoublyLL.addFirst;
import static org.learning.linkedlist.DoublyLL.print;

public class ReverseDLL {
    
    public static void main(String args[]){
        addFirst(3);
        addFirst(2);
        addFirst(1);
        print();
        
        reverse();
        print();
    }
    
    public static void reverse(){
        DoublyLL.Node curr = DoublyLL.head;
        DoublyLL.Node prev = null;
        DoublyLL.Node next;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;   // one additional line 
            prev = curr;
            curr = next;
        }
        
        DoublyLL.head= prev;
    }
}
