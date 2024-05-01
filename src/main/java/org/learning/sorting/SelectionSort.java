package org.learning.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String... args) {
        selectionSort(new int[]{6, 5, 4, 3, 2, 1});
    }

    /**
     * Time Complexity - O(n2)
     *
     * @param arr
     */

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

}
