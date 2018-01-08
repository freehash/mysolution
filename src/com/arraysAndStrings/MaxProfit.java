package com.arraysAndStrings;

/**
 * Created by hattur on 11/13/17.
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = maxProfit(prices);
        System.out.println(i);
    }
    public static int maxProfit(int[] prices) {
        int bought = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        int currentProfit = Integer.MIN_VALUE;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < bought) {
                bought = prices[i];
            }
            else {
                currentProfit = prices[i] - bought;
                if(currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }

        return maxProfit;
    }
}
