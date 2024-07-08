package org.learning.bitmanipulation;

public class ClearLastAthBits {
    public static void main(String args[]){
        System.out.println(clearLastIthBits(15, 2));
    }

    private static int clearLastIthBits(int n, int i) {
        int bitMask = (~0) <<i;
        return n & bitMask;
    }
}
