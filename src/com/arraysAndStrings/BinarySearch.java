package com.arraysAndStrings;

/**
 * Created by hattur on 11/11/17.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        //int[] nums = {3,3,7,7,10,11,11};
        //int[] nums = {4,4,5};
        //int[] nums = {4,5,5};
        int nonDuplicate = singleNonDuplicate(nums);
        System.out.println(nonDuplicate);
    }
    public static int singleNonDuplicate(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    static int binarySearch(int[] nums, int lower, int upper) {
        int mid = lower + (upper - lower)/2 ;
        if(mid == upper || mid == lower) {
            return nums[mid];
        }
        if(mid % 2 == 0) {
            if(nums[mid] == nums[mid+1]) {
                return binarySearch(nums, mid+2, upper);
            }
            else /*if (nums[mid] == nums[mid - 1])*/{
                return binarySearch(nums, lower, mid-2);
            }
            /*else {
                return nums[mid];
            }*/
        }
        else {
            if(nums[mid - 1] == nums[mid]) {
                return binarySearch(nums, mid+1, upper);
            }
            else {
                return binarySearch(nums, lower, mid);
            }
        }
    }
}
