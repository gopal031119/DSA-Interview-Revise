package org.learning.arraylist;

public class PairSumRotatedSorted {

    public static void main(String[] args) {
        int[] arr = {11, 15, 6, 8, 9, 10}; // Rotated sorted array
        int target = 16;

        if (pairSumRotated(arr, target)) {
            System.out.println("Pair exists.");
        } else {
            System.out.println("Pair does not exist.");
        }
    }

    // ================= Two-pointer approach for rotated sorted array =================
    public static boolean pairSumRotated(int[] arr, int target) {
        int n = arr.length;

        // 1. Find the pivot (largest element)
        int pivot = findPivot(arr);

        // 2. Initialize left and right pointers
        int left = (pivot + 1) % n; // smallest element
        int right = pivot;           // largest element

        // 3. Loop until left and right meet
        while (left != right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                System.out.println("Pair: (" + arr[left] + ", " + arr[right] + ")");
                return true;
            }

            if (sum < target) {
                left = (left + 1) % n; // move clockwise
            } else {
                right = (n + right - 1) % n; // move counter-clockwise
            }
        }
        return false;
    }

    // Helper method to find pivot (index of maximum element)
    public static int findPivot(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return n - 1; // array is not rotated
    }
}
