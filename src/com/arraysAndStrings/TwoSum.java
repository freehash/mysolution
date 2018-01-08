package com.arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by hattur on 10/28/17.
 */
public class TwoSum {
    public static void main(String[] args) {
        int nums[] = {3,7,1,2,8,4,5};
        System.out.println(twoSum(nums));
    }

    public static List<List<Integer>> twoSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            int num1 = nums[i];
            int difference = 10 - num1;
            if(set.contains(difference)) {
                output.add(Arrays.asList(num1, difference));
            }
            else {
                set.add(num1);
            }
        }

        return output;
    }
}
