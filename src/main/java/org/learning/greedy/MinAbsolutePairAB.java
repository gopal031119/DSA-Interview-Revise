package org.learning.greedy;

import java.util.Arrays;

public class MinAbsolutePairAB {

    public static void main(String[] args) {
        int[] a = {3, 10, 20};
        int[] b = {15, 2, 25};

        int minDiff = minAbsolutePair(a, b);
        System.out.println("Minimum absolute difference = " + minDiff);
    }

    private static int minAbsolutePair(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;

        while (i < a.length && j < b.length) {
            int diff = Math.abs(a[i] - b[j]);
            min = Math.min(min, diff);

            // move the smaller value forward
            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }

        return min;
    }
}

