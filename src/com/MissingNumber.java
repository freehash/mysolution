package com;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hattur on 10/31/17.
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        int[] errorNums = findErrorNums(nums);
        System.out.println(errorNums);
    }
    public static int[] findErrorNums(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        int[] output = new int[2];
        int sum = 0;
        for(int i = 0;i < nums.length; i++) {
            if(!set.add(nums[i])) {
                output[0] = nums[i];
            }
            else {
                sum += nums[i];
            }
        }
        int totalSum = len * (len+1)/2;
        output[1] = totalSum - sum;
        return output;
    }
}
