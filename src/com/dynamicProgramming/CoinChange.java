package com.dynamicProgramming;

/**
 * Created by hattur on 11/5/17.
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {9,6,5,1};
        int sum = 11;
        int min = findMinMemo(coins, sum);
        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(min);
        }

    }

    private static int findMin(int[] coins, int sum) {
        if(sum == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] <= sum) {
                int subResult = findMin(coins, sum - coins[i]);

                if(subResult != Integer.MAX_VALUE && subResult + 1 < result) {
                    result = subResult + 1;
                }
            }
        }
        return result;
    }

    private static int findMinMemo(int[] coins, int sum) {
        if(sum == 0) {
            return 0;
        }
        int[] memo = new int[sum+1];
        memo[0] = 0;
        for(int i = 1; i <= sum; i++) {
            memo[i] = Integer.MAX_VALUE;
        }
        int result = Integer.MAX_VALUE;
        memo[0] = 0;
        for(int i = 1; i <= sum; i++) {
            for(int j = 0; j< coins.length; j++) {
                if(coins[j] <= i) {
                    int subResult = memo[i - coins[j]];

                    if(subResult != Integer.MAX_VALUE && subResult + 1 < memo[i]) {
                        memo[i] = subResult + 1;
                    }
                }
            }
        }
        return memo[sum];
    }
}
