package org.learning.backtracking;

public class GridWays {
    public static void main(String[] args){
        int n=3;
        int m=3;
        System.out.println(gridWays(0,0,n,m));
    }

    // think about optimal solution , this is not optimal one
    private static int gridWays(int i, int j, int n, int m) {
        //base case
        if(i==n-1 && j==m-1) {
            return 1;
        }
        if(i==n || j==n) {
            return 0;
        }

        // recursion
        int w1=gridWays(i+1,j,n,m);
        int w2=gridWays(i,j+1,n,m);
        return w1+w2;
    }

}
