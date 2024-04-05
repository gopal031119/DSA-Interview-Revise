package org.learning.array;

import java.util.Arrays;

public class TrappingRainWater {

    public static void main(String... args) {
        int[] arr = {4, 2, 0, 6, 3, 2, 5};
        System.out.println(trappingWater(arr));
    }

    /**
     * Time Complexity - O(n)
     *
     * @param arr
     * @return
     */
    private static int trappingWater(int[] arr) {
        int[] maxLeft = new int[arr.length];
        int[] maxRight = new int[arr.length];

        maxLeft[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxLeft[i] = Math.max(arr[i], maxLeft[i - 1]);
        }

        maxRight[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(arr[i], maxRight[i + 1]);
        }

        int trappedWater = 0;
        for (int i = 0; i < arr.length; i++) {
            int waterLevel = Math.min(maxRight[i], maxLeft[i]);
            trappedWater += waterLevel - arr[i];
        }
        return trappedWater;
    }
}
