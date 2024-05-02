package org.learning.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String... args) {
        int arr[] = new int[]{-2, 6, 5, 4, 3, 2, 1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Time Complexity - O(nlogn)
     * Space Complexity - O(n)
     *
     * @param arr
     * @param si
     * @param ei
     */
    private static void mergeSort(int[] arr, int si, int ei) {

        if (si >= ei) {
            return;
        }

        int mid = (si + ei) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    private static void merge(int[] arr, int si, int mid, int ei) {
        int[] temp = new int[ei - si + 1];
        int i = si; // ind for 1st sort part
        int j = mid + 1; // idx for 2nd sort part
        int k = 0; //idx for temp

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        // For left over element of first sorted array
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // For left over element of second sorted array
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

    }
}
