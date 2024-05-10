package org.learning.backtracking;

public class PrintArray {
    public static void main(String args[]){
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        printArray(arr);
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     * 
     * @param arr
     * @param i
     * @param val
     */
    private static void changeArr(int[] arr, int i, int val) {
        if(arr.length == i) {
            printArray(arr);
            return;
        }
        arr[i]=val;
        changeArr(arr, i+1, val+1); // recursive call
        arr[i]=arr[i]-2; // backtracking call
    }

    public static void printArray(int arr[]){
        for(int x : arr){
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
