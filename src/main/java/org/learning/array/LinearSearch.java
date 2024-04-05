package org.learning.array;

public class LinearSearch {
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(linearSearch(arr, 9));
    }

    /**
     * Time complexity - O(n)
     * @param arr
     * @param val
     * @return
     */
    private static boolean linearSearch(int[] arr, int val) {
        for(int x:arr){
            if(x==val){
                return true;
            }
        }
        return false;
    }
}
