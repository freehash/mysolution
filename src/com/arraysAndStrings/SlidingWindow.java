package com.arraysAndStrings;

/**
 * Created by hattur on 10/28/17.
 */
public class SlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] max = findSlidingWindowMax(nums, k);
        System.out.println(max);
    }

    private static int[] findSlidingWindowMax(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return new int[]{};
        }
        int[] max = new int[nums.length - k + 1];
        for(int i = 0; i <= nums.length - k; i++) {
            max[i] = findMax(nums,i, i+k);
        }
        return max;
    }

    private static int findMax(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        for(int i = left; i<right; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }
}
