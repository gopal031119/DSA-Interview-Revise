package org.learning.twodarray;

public class SearchInSortedMatrix {
    public static void main(String...args){
        int arr[][] = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        searchInSortedMat(arr, 37);
    }

    /**
     * Time complexity - O(n+m)
     * @param arr
     * @param target
     */
    private static void searchInSortedMat(int[][] arr,int target) {
        int row=0;
        int col=arr[0].length-1;
        
        while(row<arr.length && col>=0){
            if(target==arr[row][col]){
                System.out.println(row+ " " + col);
                return;
            }
            else if(target<arr[row][col]){
                col--;
            } else {
                row++;
            }
        }
        System.out.println("No element found !!");
    }
}
