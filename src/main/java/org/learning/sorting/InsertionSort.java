package org.learning.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String... args) {
        insertionSort(new int[]{6, 5, 4, 3, 2, 1});
    }

    /**
     * Time Complexity - O(n2)
     *
     * @param arr
     */
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            // finding position to insert it
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            //inserting curr element
            arr[prev + 1] = curr;
        }
        System.out.println(Arrays.toString(arr));
    }
}
