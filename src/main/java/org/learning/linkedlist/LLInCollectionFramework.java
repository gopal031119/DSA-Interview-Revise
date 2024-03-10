package org.learning.linkedlist;

import java.util.LinkedList;

public class LLInCollectionFramework {
    public static void main(String args[]){
        LinkedList<Integer> ll = new LinkedList<>();
        
        // some operations
        ll.add(2);
        ll.addFirst(1);
        ll.addLast(3);
        System.out.println(ll);
        
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);
    }
}
