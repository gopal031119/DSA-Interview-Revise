package org.learning.array;

public class PairsInArray {
    public static void main(String args[]) {
        int[] arr = {2, 4, 6, 8, 10};
        pairsInArray(arr);
    }

    /**
     * Time Complexity - O(n2)
     * @param arr
     */
    private static void pairsInArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }
            System.out.println();
        }
    }
}
