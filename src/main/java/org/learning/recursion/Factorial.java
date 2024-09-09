package org.learning.recursion;

public class Factorial {
    public static void main(String args[]){
        System.out.println(factorial(5));
    }


    /**
     * Tc - O(n)
     * Sc - O(n)
     *
     * @param n
     */
    private static int factorial(int n) {
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
}
