package org.learning.recursion;

public class PrintXPowN {

    public static void main(String args[]) {
        System.out.println(printXPowN(5, 3));
        System.out.println(optimizedPow(5,3));
    }


    /**
     * Tc - O(n)
     * Sc - O(n)
     *
     * @param n
     */
    private static int printXPowN(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x*printXPowN(x,n - 1);
    }

    /**
     * 
     * TC - O(logn)
     * SC - O(logn)
     * 
     * @param x
     * @param n
     * @return
     */
    private static int optimizedPow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        
        int halPowSq = optimizedPow(x, n/2)* optimizedPow(x, n/2);
        
        if(n % 2 != 0){
            halPowSq = x * halPowSq;
        }
        return halPowSq;
    }
    
    

}
