package org.learning.stack;

import java.util.Stack;

public class validParentheses {

    public static void main(String args[]) {
        String str = "({[]})";
        System.out.println(isValidParentheses(str));
    }

    /**
     * Time complexity - O(n)
     *
     * @param str
     * @return
     */
    private static boolean isValidParentheses(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == '{' || curr == '[' || curr == '(') {
                st.push(curr);
            } else {
                if (st.empty()) {
                    return false;
                }
                if ((curr == '}' && st.peek() == '{') ||
                        (curr == ')' && st.peek() == '(') ||
                        (curr == ']' && st.peek() == '[')) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        if (st.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
