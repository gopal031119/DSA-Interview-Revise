package org.learning.recursion;

public class PrintSumOfN {

    public static void main(String args[]) {
        System.out.println(printSumOfN(5));
    }


    /**
     * Tc - O(n)
     * Sc - O(n)
     *
     * @param n
     */
    private static int printSumOfN(int n) {
        if (n == 1) {
            return 1;
        }
        return n + printSumOfN(n - 1);
    }
    
}
