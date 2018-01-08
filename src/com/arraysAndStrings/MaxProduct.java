package com.arraysAndStrings;

/**
 * Created by hattur on 11/11/17.
 */
public class MaxProduct {

    public static void main(String[] args) {
        //int[] nums = {2,3,-2,4};
        //int[] nums = {0,2};
        //int[] nums = {-2,3,-4};
        int[] nums = {2,-5,-2,-4,3};
        //int[] nums = {-2,0,-1};
        int maxProduct = getMaxProduct(nums);
        System.out.println(maxProduct);
    }

    public static int getMaxProduct(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int maxProduct = nums[0];
        int runningProductMax = nums[0];
        int runningProductMin = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = runningProductMax;
                runningProductMax = runningProductMin;
                runningProductMin = temp;
            }
            runningProductMax = Math.max(nums[i], runningProductMax * nums[i]);
            runningProductMin = Math.min(nums[i], runningProductMin * nums[i]);
            maxProduct = Math.max(maxProduct, runningProductMax);
        }
        return maxProduct;
    }
}
