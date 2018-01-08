package com.arraysAndStrings;

/**
 * Created by hattur on 11/11/17.
 */
public class FirstMissingPositiveInteger {
    public static void main(String[] args) {
        //int[] nums = {1,2,0};
        //int[] nums = {3,17,-1,1};
        int[] nums = {2,1,4,6,5,3};
        //int[] nums = {2};
        int i = firstMissingPositive(nums);
        System.out.println(i);
    }
    public static int firstMissingPositive(int[] nums) {
        int max = findMaxNumber(nums);
        if(max <= 0) {
            return 1;
        }
        int[] temp = new int[max];

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num > 0) {
                temp[num-1] = num;
            }
        }

        for(int i = 0; i < temp.length; i++) {
            if(temp[i] == 0) {
                return i+1;
            }
        }
        return temp.length + 1;
    }

    private static int findMaxNumber(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }
}
