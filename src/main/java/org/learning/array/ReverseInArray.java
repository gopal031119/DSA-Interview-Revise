package org.learning.array;

import java.util.Arrays;
import java.util.Collections;

public class ReverseInArray {
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(reverseInArray(arr)));
    }

    /**
     * Time Complexity - O(n), Space Complexity - O(1)
     * @param arr
     * @return
     */
    private static int[] reverseInArray(int[] arr) {
       int left=0,right=arr.length-1;
       while(left<=right){
           int temp = arr[left];
           arr[left]=arr[right];
           arr[right]=temp;
           left++;
           right--;
       }
       return arr;
    }
}
