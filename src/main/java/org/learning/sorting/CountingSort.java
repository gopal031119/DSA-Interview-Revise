package org.learning.sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String... args) {
        countingSort(new int[]{6, 5, 4, 3, 2, 1});
    }

    /**
     * Time Complexity - O(n+k)
     * Space Complexity - O(k)
     *
     * @param arr
     */
    private static void countingSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int[] count = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
