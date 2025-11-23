package org.learning.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class IndianCoin {

    public static void main(String[] args) {
        int amount = 590;
        Integer[] coins = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};

        minCoins(coins, amount);
    }

    private static void minCoins(Integer[] coins, int amount) {
        // Sort in descending order
        Arrays.sort(coins, Comparator.reverseOrder());

        System.out.println("Coins used:");
        int count =0;
        for (int coin : coins) {
            while (amount >= coin) {
                System.out.print(coin + " ");
                amount -= coin;
                count++;
            }
        }
        System.out.println();
        System.out.println("count: "+count);
    }
}
