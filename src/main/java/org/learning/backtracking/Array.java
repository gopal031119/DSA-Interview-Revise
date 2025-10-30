package org.learning.backtracking;

import java.util.Arrays;

public class Array {

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        printArray(arr);
        performArrayOperation(arr, 0 ,1);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    private static void performArrayOperation(int[] arr, int i, int val) {
        //base case
        if(arr.length==i){
            return;
        }
        // recursion
        arr[i]=val;
        performArrayOperation(arr,i+1,val+1);
        arr[i]=val-2;
    }
}
