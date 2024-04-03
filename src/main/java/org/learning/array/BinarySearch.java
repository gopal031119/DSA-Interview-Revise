package org.learning.array;

public class BinarySearch {

    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(arr, 9));
    }
    
    /**
     * Time Complexity - O(log n)
     *
     * @param arr
     * @param val
     * @return
     */
    public static boolean binarySearch(int arr[], int val) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == val) {
                return true;
            }
            if (val < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
