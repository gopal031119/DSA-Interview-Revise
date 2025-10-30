package org.learning.backtracking;

public class FindSubsets {
    public static void main(String[] args){
        String str="abc";
        findSubsets(str,"", 0);
    }

    private static void findSubsets(String str,String ans, int i) {
        //base case
        if(str.length()==i){
            System.out.println(ans);
            return;
        }
        //recursion - yes
        findSubsets(str, ans+str.charAt(i),i+1);
        //choice - no
        findSubsets(str, ans,i+1);
    }

}
