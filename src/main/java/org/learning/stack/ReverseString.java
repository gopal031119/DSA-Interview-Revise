package org.learning.stack;

import java.util.Stack;

public class ReverseString {
    public static void main(String args[]){
        String text= "abcd";
        System.out.println(reverseString(text));
    }

    private static String reverseString(String text) {
        Stack<Character> st = new Stack<>();
        int len = text.length();
        for(int i =0;i<text.length();i++){
            st.push(text.charAt(i));
        }
        String str = "";
        while (!st.isEmpty()){
            str += st.pop();
        }
        return str;
    }
}
