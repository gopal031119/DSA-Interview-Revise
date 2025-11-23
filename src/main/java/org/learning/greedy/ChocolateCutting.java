package org.learning.greedy;

import java.util.Arrays;
import java.util.Collections;

public class ChocolateCutting {

    public static void main(String[] args) {
        // Cost of horizontal cuts
        Integer[] horizontal = {2, 1, 3, 1, 4};

        // Cost of vertical cuts
        Integer[] vertical = {4, 1, 2};

        int totalCost = minChocolateCutCost(horizontal, vertical);
        System.out.println("Minimum total cutting cost = " + totalCost);
    }

    private static int minChocolateCutCost(Integer[] horizontal, Integer[] vertical) {
        // Step 1: Sort the cut costs in descending order
        // This allows us to always pick the largest cost first
        Arrays.sort(horizontal, Collections.reverseOrder());
        Arrays.sort(vertical, Collections.reverseOrder());

        int hPieces = 1; // number of horizontal pieces
        int vPieces = 1; // number of vertical pieces
        int cost = 0;    // total cost

        int i = 0; // pointer for horizontal cuts
        int j = 0; // pointer for vertical cuts

        // Step 2: Pick the largest cut each time
        while (i < horizontal.length && j < vertical.length) {
            if (horizontal[i] > vertical[j]) {
                // Take horizontal cut
                cost += horizontal[i] * vPieces;
                hPieces++; // horizontal cut increases number of horizontal pieces
                i++;
            } else {
                // Take vertical cut
                cost += vertical[j] * hPieces;
                vPieces++; // vertical cut increases number of vertical pieces
                j++;
            }
        }

        // Step 3: Add remaining horizontal cuts (if any)
        while (i < horizontal.length) {
            cost += horizontal[i] * vPieces;
            i++;
        }

        // Step 4: Add remaining vertical cuts (if any)
        while (j < vertical.length) {
            cost += vertical[j] * hPieces;
            j++;
        }

        return cost;
    }
}
