package org.learning.twodarray;

public class DiagonalSum {
    public static void main(String...args){
        int arr[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        diagonalSum(arr);
    }

    /**
     * Time Complexity - O(n)
     * @param arr
     */
    private static void diagonalSum(int[][] arr) {
        int n= arr.length;
        int m= arr[0].length;
        
        if(n != m) {
            return;
        }
        int fistDiagonalSum=0;
        int secondDiagonalSum=0;
        for(int i=0;i<n;i++){
            fistDiagonalSum += arr[i][i];
            secondDiagonalSum += arr[i][n-i-1];
        }
        System.out.println(fistDiagonalSum + " "+ secondDiagonalSum);
    }

}
