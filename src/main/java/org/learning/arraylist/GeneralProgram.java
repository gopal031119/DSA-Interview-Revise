package org.learning.arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class GeneralProgram {

    public static void main(String[] args) {
        System.out.println("=== Using ArrayList (Collections) ===");
        arrayListWithCollections();

        System.out.println("\n=== Using ArrayList (Manual Logic) ===");
        arrayListManual();
    }

    // ===================== ArrayList using Collections =====================
    public static void arrayListWithCollections() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 5, 2, 9, 1, 7);
        System.out.println("Original List: " + numbers);

        // Reverse
        Collections.reverse(numbers);
        System.out.println("Reversed List: " + numbers);

        // Max
        int max = Collections.max(numbers);
        System.out.println("Maximum number: " + max);

        // Swap index 1 and 3
        Collections.swap(numbers, 1, 3);
        System.out.println("After swapping index 1 and 3: " + numbers);

        // Sort ascending
        Collections.sort(numbers);
        System.out.println("Sorted Ascending: " + numbers);

        // Sort descending
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Sorted Descending: " + numbers);

        // 2D ArrayList
        ArrayList<ArrayList<Integer>> twoDList = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        Collections.addAll(row1, 1, 2, 3);
        ArrayList<Integer> row2 = new ArrayList<>();
        Collections.addAll(row2, 4, 5, 6);
        ArrayList<Integer> row3 = new ArrayList<>();
        Collections.addAll(row3, 7, 8, 9);
        twoDList.add(row1);
        twoDList.add(row2);
        twoDList.add(row3);

        System.out.println("2D List:");
        for (ArrayList<Integer> row : twoDList) {
            System.out.println(row);
        }
    }

    // ===================== ArrayList Manual Logic =====================
    public static void arrayListManual() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(9);
        numbers.add(1);
        numbers.add(7);
        System.out.println("Original List: " + numbers);

        // Reverse manually
        reverseArrayList(numbers);
        System.out.println("Reversed List: " + numbers);

        // Find max manually
        int max = findMax(numbers);
        System.out.println("Maximum number: " + max);

        // Swap manually (index 1 and 3)
        swap(numbers, 1, 3);
        System.out.println("After swapping index 1 and 3: " + numbers);

        // Sort ascending manually (bubble sort)
        bubbleSort(numbers);
        System.out.println("Sorted Ascending (Manual): " + numbers);

        // 2D ArrayList manually
        ArrayList<ArrayList<Integer>> twoDList = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1); row1.add(2); row1.add(3);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(4); row2.add(5); row2.add(6);
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(7); row3.add(8); row3.add(9);
        twoDList.add(row1);
        twoDList.add(row2);
        twoDList.add(row3);

        System.out.println("2D List:");
        for (ArrayList<Integer> row : twoDList) {
            System.out.println(row);
        }
    }

    // ===================== Manual Helper Methods =====================
    public static void reverseArrayList(ArrayList<Integer> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static int findMax(ArrayList<Integer> list) {
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void bubbleSort(ArrayList<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    swap(list, j, j + 1);
                }
            }
        }
    }
}
