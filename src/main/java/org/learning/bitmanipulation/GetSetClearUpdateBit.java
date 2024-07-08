package org.learning.bitmanipulation;

public class GetSetClearUpdateBit {
    public static void main(String args[]) {
        int n = 5, i = 2;
        System.out.println(getBit(n, i));
        System.out.println(setBit(n, i));
        System.out.println(clearBit(n, i));
        System.out.println(updateBit(10, 2 , 1));
    }

    private static int updateBit(int n, int i, int newBit) {
        n = clearBit(n , i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    private static int clearBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    private static int setBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    private static int getBit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
