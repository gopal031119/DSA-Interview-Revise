package org.learning.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChainPair {

    public static void main(String[] args) {
        int[][] pairs = {
                {5, 24},
                {15, 25},
                {27, 40},
                {50, 60}
        };

        int maxChain = maxChainLength(pairs);
        System.out.println("Maximum chain length = " + maxChain);
    }

    private static int maxChainLength(int[][] pairs) {
        // sort by the second element
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));

        int count = 1;                    // at least one pair can be taken
        int lastEnd = pairs[0][1];        // end of the first pair

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > lastEnd) {  // valid next pair
                count++;
                lastEnd = pairs[i][1];
            }
        }

        return count;
    }
}
