package org.learning.recursion;

import java.sql.Array;

public class CheckArrayIsSortedOrNot {
    public static void main(String args[]){
        int arr[] = {1,2,4,3,5};
        System.out.println(checkSortedOrNot(arr, 0));
    }


    /**
     * Tc - O(n)
     * Sc - O(n)
     *
     */
    private static boolean checkSortedOrNot(int arr[], int i) {
        
        if(i == arr.length-1){
            return true;
        }
        
        if(arr[i] > arr[i+1]){
            return false;
        }
        
        return checkSortedOrNot(arr, i+1);
    }
}
