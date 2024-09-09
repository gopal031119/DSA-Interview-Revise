package org.learning.recursion;

public class PrintNto1 {
    public static void main(String args[]){
        printNtoOne(10);
    }

    /**
     * Tc - O(n)
     * Sc - O(n)
     * 
     * @param n
     */
    private static void printNtoOne(int n) {
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printNtoOne(n-1);
    }
}
