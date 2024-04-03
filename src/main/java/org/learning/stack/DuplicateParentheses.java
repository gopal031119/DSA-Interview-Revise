package org.learning.stack;

import java.util.Stack;

public class DuplicateParentheses {

    public static void main(String args[]) {
        // always proper string will be pass , so you can avoid st.empty check in while loop
        String test = "((a+b) + (c+d))";
        System.out.println(isDuplicateParentheses(test));
    }

    /**
     * 
     * Time Complexity - O(n)
     * @param str
     * @return
     */
    private static boolean isDuplicateParentheses(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == ')') {
                int count = 0;
                while (st.peek() != '(') {
                    st.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    st.pop();
                }
            } else {
                st.push(curr);
            }
        }
        return false;
    }
}
