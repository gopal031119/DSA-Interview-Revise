package org.learning.recursion;

public class Print1toN {
    public static void main(String args[]){
        printOnetoN(10);
    }
    

    /**
     * Tc - O(n)
     * Sc - O(n)
     *
     * @param n
     */
    private static void printOnetoN(int n) {
        if(n==1){
            System.out.println(n);
            return;
        }
        printOnetoN(n-1);
        System.out.println(n);
    }
}
