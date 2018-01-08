package com.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hattur on 11/5/17.
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,3,7,7,7,8,7,4,5,6,5};
        int i = majorityElementModified(nums);
        System.out.println(i);
    }

    public static int majorityElementModified(int[] nums) {
        int a = nums[0];
        int count = 0;
        for(int num : nums){
            if(count == 0){
                a = num;
                count++;
            }
            else{
                if(num != a){
                    count--;
                }
                else{
                    count++;
                }
            }
        }
        return a;
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = nums.length;

        for(int i : nums) {
            if(map.containsKey(i)) {
                if(map.get(i) == size/2) {
                    return i;
                }
                map.put(i, map.get(i) + 1);
            }
            else {
                map.put(i, 1);
            }
        }

        return -1;

    }
}
