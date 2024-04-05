package org.learning.array;

public class BuySellStock {
    public static void main(String... args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

    /**
     * Time Complexity - O(n)
     * 
     * @param arr
     * @return
     */
    private static int maxProfit(int[] arr) {
        int minBuyingPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            minBuyingPrice = Math.min(arr[i],minBuyingPrice);
            int sellingPrice = arr[i];
            maxProfit= Math.max(maxProfit, sellingPrice-minBuyingPrice);
        }
        return maxProfit;
    }
}
