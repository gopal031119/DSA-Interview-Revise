package org.learning.recursion;

public class Fibonacci {
    public static void main(String args[]){
        System.out.println(nthFibonacci(5));
    }


    /**
     * Tc - O(2^n)
     * Sc - O(n)
     *
     * @param n
     */
    private static int nthFibonacci(int n) {
        if(n==1 || n==0){
            return n;
        }
        return nthFibonacci(n-1) + nthFibonacci(n-2);
    }
}
