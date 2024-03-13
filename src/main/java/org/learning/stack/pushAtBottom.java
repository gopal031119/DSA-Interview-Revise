package org.learning.stack;

import java.util.Stack;

public class pushAtBottom {
    
    public static void main(String args[]){
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st);
        stackPushAtBottom(st, 4);
        System.out.println(st);
    }

    private static void stackPushAtBottom(Stack<Integer> st, int data) {
        if(st.isEmpty()){
            st.push(data);
            return;
        }
        int top = st.pop();
        stackPushAtBottom(st,data);
        st.push(top);
    }
}
