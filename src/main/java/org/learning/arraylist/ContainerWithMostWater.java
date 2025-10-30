package org.learning.arraylist;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println("Brute Force Maximum Area: " + maxAreaBruteForce(height));
        System.out.println("Two Pointer Maximum Area: " + maxAreaTwoPointer(height));
    }

    // ================= Brute Force Approach =================
    public static int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        int n = height.length;

        // Check all pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int width = j - i;
                int currentHeight = Math.min(height[i], height[j]);
                int area = width * currentHeight;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    // ================= Two Pointer Approach =================
    public static int maxAreaTwoPointer(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int area = width * currentHeight;
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
