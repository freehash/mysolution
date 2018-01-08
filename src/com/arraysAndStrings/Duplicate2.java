package com.arraysAndStrings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hattur on 11/11/17.
 */
public class Duplicate2 {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        boolean b = containsDuplicate(nums, 0);
        System.out.println(b);
    }

    public static boolean containsDuplicate(int[] nums, int diff) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                Integer prevIndex = map.get(nums[i]);
                if(Math.abs(i - prevIndex) <= diff) {
                    return true;
                }
                else {
                    map.put(nums[i], i);
                }
            }
            else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
