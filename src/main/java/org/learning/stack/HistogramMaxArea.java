package org.learning.stack;

import java.util.Stack;

public class HistogramMaxArea {

    public static void main(String args[]) {
        int arr[] = {2, 1, 5, 6, 2, 3}; //heights in histogram
        System.out.println(maxarea(arr));
    }

    /**
     * 1. find next smaller right
     * 2. find next smaller left
     * 3. calculate area
     * 
     * @param arr
     * @return
     */
    private static int maxarea(int[] arr) {
        int max = Integer.MIN_VALUE;
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];

        // next smaller right
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = st.peek();
            }
            st.push(i);
        }

        // next smaller left
        st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = st.peek();
            }
            st.push(i);
        }

        //calculate area

        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            max = Math.max(currArea, max);
        }
        return max;
    }


}
