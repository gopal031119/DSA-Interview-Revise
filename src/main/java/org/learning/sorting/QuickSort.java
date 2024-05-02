package org.learning.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String... args) {
        int arr[] = new int[]{-2, 6, 5, 4, 3, 2, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Time complexity avg case - O(nlogn)
     *
     * @param arr
     * @param si
     * @param ei
     */
    private static void quickSort(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int pivotIndex = partition(arr, si, ei);
        quickSort(arr, si, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, ei);
    }

    private static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1; // to make place for elements smaller than pivot

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap 
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        // swap for pivot element
        i++;
        // swap 
        int temp = pivot;
        arr[ei] = arr[i]; // don't take pivot = arr[i], because pivot is variable, and we need to switch element in array
        arr[i] = temp;

        return i;
    }
}
