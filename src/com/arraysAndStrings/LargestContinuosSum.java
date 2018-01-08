package com.arraysAndStrings;

/**
 * Created by hattur on 10/17/17.
 */
public class LargestContinuosSum {
    public static void main(String[] args) {
        //int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {-1, -2};
        //int[] nums = {-2, 1};
        //int[] nums = {1};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];

        for(int i = 1;i < nums.length; i++) {
            sum += nums[i];
            if(sum < nums[i]) {
                sum = nums[i];
            }
            if(maxSum < sum) {
                maxSum = sum;
            }
            else  if(sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
