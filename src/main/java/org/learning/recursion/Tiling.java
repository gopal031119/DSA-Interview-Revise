package org.learning.recursion;

public class Tiling {
    public static void main(String args[]){
        System.out.println(tilingWay(4));
    }
    
    private static int tilingWay(int n) {
        boolean smtg = false;
        boolean smtg2 = true;
        if(!smtg && smtg2){
            System.out.println("true....");
        }
        
        if(n==0 || n==1){
            return 1;
        }
        
        // vertical choice
        int vertical = tilingWay(n-1);
        // horizontal choice
        int horizontal = tilingWay(n-2);
        
        return vertical+ horizontal;
    }
}
