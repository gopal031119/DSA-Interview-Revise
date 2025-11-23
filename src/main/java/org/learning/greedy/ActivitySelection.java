package org.learning.greedy;

import java.util.ArrayList;

public class ActivitySelection {
    public static void main(String[] args) {
        int[] start = {10, 12, 20};
        int[] end = {20, 25, 30};
        int maxAct = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        int lastEnd = end[0];

        for (int i = 1; i < start.length; i++) {
            if (start[i] >= lastEnd) {
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println(ans);
    }

}
