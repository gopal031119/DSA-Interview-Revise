package org.learning.bitmanipulation;

public class FastExponentiation {
    public static void main(String args[]) {
        System.out.println(fastExponentiation(3, 5));
    }

    private static int fastExponentiation(int a, int b) {
        int ans = 1;
        while (b > 0) {
            if((b & 1) != 0){
                ans = ans * a;
            }
            a= a* a;
            b = b >> 1; 
        }
        return ans;
    }
}
