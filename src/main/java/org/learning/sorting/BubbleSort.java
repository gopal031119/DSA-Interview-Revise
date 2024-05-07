package org.learning.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String... args) {
        bubbleSort(new int[]{6, 5, 4, 3, 2, 1});
    }

    /**
     * Time Complexity - O(n2)
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int swap = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap++;
                }
            }
            if (swap == 0) break;
        }
        System.out.println(Arrays.toString(arr));
    }
}
