package org.learning.bitmanipulation;

public class OddOrEven {
    
    
    public static void main(String args[]){
        oddOrEven(8);
        oddOrEven(3);
    }

    private static void oddOrEven(int n) {
        int bitmask = 1;
        if((n & bitmask) == 0){
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
    }
}
