package org.learning.array;

public class LargestInArray {
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Largest(arr));
    }

    /**
     * Time complexity - O(n)
     * @param arr
     * @return
     */
    private static int Largest(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int x: arr){
            max = Math.max(x, max);
        }
        return max;
    }
}
