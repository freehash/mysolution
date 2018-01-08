package com.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hattur on 11/1/17.
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int n = 20;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        int i = climbStairs(n, memo);
        System.out.println(i);
    }
    public static int climbStairs(int n, int[] memo) {
        if(n < 0) {
            return 0;
        }
        else if(n == 0) {
            return 1;
        }
        else if(memo[n] > -1) {
            return memo[n];
        }
        else {
            memo[n] = climbStairs(n-1, memo) + climbStairs(n-2, memo);
        }
        return memo[n];
    }
}
