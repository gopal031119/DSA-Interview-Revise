package org.learning.string;

public class ShortestPath {
    public static void main(String args[]){
        System.out.println(shortenPath("WNEENESENNN"));
    }

    /**
     * Time complexity - O(n)
     * @param str
     * @return
     */
    private static double shortenPath(String str) {
        int x=0;
        int y=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='N'){
                y++;
            }
            else if(str.charAt(i)=='S'){
                y--;
            }
            else if(str.charAt(i)=='E'){
                x++;
            }
            else if(str.charAt(i)=='W'){
                x--;
            }
            else{
                return -1;
            }
        }
        return Math.sqrt((x*x)+(y*y));
    }


}
