package org.learning.bitmanipulation;

public class CountSetBits {
    public static void main (String args[]){
        System.out.println(countSetBits(15));
    }

    private static int countSetBits(int n) {
        int count = 0;
        while(n>0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
