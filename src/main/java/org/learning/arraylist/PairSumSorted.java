package org.learning.arraylist;

import java.util.ArrayList;

public class PairSumSorted {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        // Sorted ArrayList
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);

        int target = 7;

        System.out.println("Brute Force Pairs:");
        pairSumBruteForce(numbers, target);

        System.out.println("\nTwo Pointer Pairs:");
        pairSumTwoPointer(numbers, target);
    }

    // ================= Brute Force Approach =================
    public static void pairSumBruteForce(ArrayList<Integer> list, int target) {
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (list.get(i) + list.get(j) == target) {
                    System.out.println("(" + list.get(i) + ", " + list.get(j) + ")");
                }
            }
        }
    }

    // ================= Two Pointer Approach =================
    public static void pairSumTwoPointer(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == target) {
                System.out.println("(" + list.get(left) + ", " + list.get(right) + ")");
                left++;
                right--; // move both pointers after finding a pair
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
