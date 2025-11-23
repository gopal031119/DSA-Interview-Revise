package org.learning.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection2 {

    public static void main(String... args) {
        int[] start = {0, 1, 3, 5, 8};
        int[] end   = {6, 2, 4, 7, 9};
        activitySelection2(start, end);
    }

    private static void activitySelection2(int[] start, int[] end) {

        // Create activity array: {index, start, end}
        int[][] activities = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;        // index
            activities[i][1] = start[i]; // start time
            activities[i][2] = end[i];   // end time
        }

        // Sort by end time (activities[][2])
        Arrays.sort(activities, Comparator.comparingInt(a -> a[2]));

        System.out.println("Selected activities (index, start, end):");

        // Greedy selection
        int lastEnd = -1;
        for (int[] act : activities) {
            if (act[1] >= lastEnd) { // start >= last selected end
                System.out.println(Arrays.toString(act));
                lastEnd = act[2];
            }
        }
    }
}
