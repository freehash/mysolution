package com.arraysAndStrings;

/**
 * Created by hattur on 10/28/17.
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7}; //{5,6,7,1,2,3,4}
        //int[] nums = {-1}; //{5,6,7,1,2,3,4}
        //int[] nums = {1,2};
        //int[] nums = {1,2,3};
        int k = 2;
        rotate(nums, k);
        System.out.println(nums);
    }

    private static void rotate(int[] nums, int k) {
        if(k == 0 || nums.length == 0 || k < 0 || nums.length == 1) {
            return ;
        }
        if(k > nums.length) {
            k = k % nums.length;
        }
        int[] temp = new int[k];
        int c = 0;

        for(int i = nums.length - k; i < nums.length; i++) {
            temp[c] = nums[i];
            c++;
        }

        for(int i = nums.length - k - 1; i >= 0; i--) {
            int newIndex = (i+k)%nums.length;
            nums[newIndex] = nums[i];
        }

        for(int i = 0;i < k ;i++) {
            nums[i] = temp[i];
        }
    }
}
