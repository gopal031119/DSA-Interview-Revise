package org.learning.bitmanipulation;

public class PowerOfTwoOrNot {
    public static void main (String args[]){
        powerOfTwoOrNot(8);
    }

    private static void powerOfTwoOrNot(int n) {
        if((n & n-1) == 0) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
    }
}
