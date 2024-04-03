package org.learning.stack;

import java.util.Arrays;
import java.util.Stack;


public class NextGreater {

    public static void main(String args[]) {
        int[] arr = {6, 8, 0, 1, 3};
        int[] nextGreaterArray = new int[arr.length];

        nextGreater(arr, nextGreaterArray);
        System.out.println(Arrays.toString(nextGreaterArray));
    }


    /**
     * Time complexity - O(n)
     */
    private static void nextGreater(int[] arr, int[] nextGreaterArray) {
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nextGreaterArray[i] = -1;
            } else {
                nextGreaterArray[i] = arr[st.peek()];
            }

            st.push(i);
        }
    }
}
