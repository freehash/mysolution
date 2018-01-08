package com.arraysAndStrings;

import java.util.Arrays;

/**
 * Created by hattur on 11/10/17.
 */
public class RemoveInPlace {

    public static void main(String[] args) {
        //int[] nums = {3,2,2,3};
        int[] nums = {3,2,5,3,2,8};
        //int newLength = removeElement(nums, 3);
        //System.out.println(newLength);

        //int[] nums1 = {0,0,0,0,0,1,2,2,3,3,4,4};
        //int[] nums1 = {1,2,2,3,3,4};
        //int[] nums1 = {1,2,3};
        //int[] nums1 = {1,1,2};
        //int[] nums1 = {1};
        //int[] nums1 = {1,1};
        int newLength1 = removeElement(nums);
        System.out.println(newLength1);
    }

    public static int removeElement(int[] nums) {
        int index = 1;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i] >= nums[i+1]) {
                int nextElementIndex = findNextElementIndex(nums, i, nums[i]);
                if(nextElementIndex != -1) {
                    nums[index] = nums[nextElementIndex];
                }
                else {
                    return index;
                }
            }
            index++;
        }
        return index;
    }



    private static int findNextElementIndex(int[] nums, int index, int val) {
        for(int i = index; i < nums.length; i++) {
            if(nums[i] > val) {
                return i;
            }
        }
        return -1;
    }


    public static int removeElement(int[] nums, int val) {
        int s_idx=0;
        int e_idx=0;
        for(int num:nums)
        {
            if(num!=val)
                nums[s_idx++]=num;


        }
        return s_idx;
    }

    private static int remove(int[] nums, int val) {
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            if(nums[i] == val) {
                int index = findSwapIndex(nums, val, i);
                if(index == -1) {
                    return i;
                }
                swap(nums, i, index);
            }
        }
        return length;
    }

    private static void swap(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

    private static int findSwapIndex(int[] nums, int val, int currentIndex) {
        for(int i = nums.length - 1; i >=currentIndex; i--) {
            if(nums[i] != val) {
                return i;
            }
        }
        return -1;
    }
}
