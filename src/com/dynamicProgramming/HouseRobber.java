package com.dynamicProgramming;

import javax.swing.*;
import java.util.*;

/**
 * Created by hattur on 11/3/17.
 */
public class HouseRobber {

    public static void main(String[] args) {
        //int[] nums = {1,3,4,2,6};
        int[] nums = {2,1,1,2};
        int maxSum = rob(nums);
        int maxSum2 = rob2(nums, 0);
        System.out.println(maxSum);
    }

    public static int rob2(int[] num, int index) {
        if(index >= num.length) {
            return 0;
        }
        int include = num[index] + rob2(num, index + 2);
        int notInclude = rob2(num, index + 1);

        return Math.max(include, notInclude);
    }

    public static int rob3(int[] num, int index, int[] memo) {
        if(index >= num.length) {
            return 0;
        }
        if(memo[index] == 0) {
            int include = num[index] + rob2(num, index + 2);
            int notInclude = rob2(num, index + 1);
            memo[index] = Math.max(include, notInclude);
        }
        return memo[index];
    }

    public static int rob4(int[] num) {
        int[] memo = new int[num.length + 2];
        memo[num.length] = 0;
        memo[num.length+1] = 0;

        for(int i = num.length-1;i>=0;i--) {
            int bestWith = num[i] + memo[i+2];
            int bestWithout = memo[i+1];
            memo[i] = Math.max(bestWith, bestWithout);
        }

        return memo[0];

    }
    public static int rob(int[] num) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : num) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }
}
