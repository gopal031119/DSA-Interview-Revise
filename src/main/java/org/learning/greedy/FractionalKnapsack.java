package org.learning.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static void main(String[] args) {
        int[] value  = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int maxWeight = 50;

        double maxVal = fractionalKnapsack(value, weight, maxWeight);
        System.out.println("Maximum value = " + maxVal);
    }

    private static double fractionalKnapsack(int[] value, int[] weight, int maxWeight) {
        double[][] items = new double[value.length][3]; // {value, weight, ratio}

        for (int i = 0; i < value.length; i++) {
            items[i][0] = value[i];
            items[i][1] = weight[i];
            items[i][2] = (double) value[i] / weight[i];
        }

        Arrays.sort(items, Comparator.comparingDouble(a -> -a[2])); // sort by ratio desc

        double remaining = maxWeight;
        double total = 0;

        for (double[] item : items) {
            if (remaining == 0) break;

            if (remaining >= item[1]) {
                total += item[0];
                remaining -= item[1];
            } else {
                double fraction = remaining / item[1];
                total += item[0] * fraction;
                remaining = 0;
            }
        }

        return total;
    }
}
