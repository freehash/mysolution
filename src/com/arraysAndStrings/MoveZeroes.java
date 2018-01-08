package com.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by hattur on 11/17/17.
 */
public class MoveZeroes {
    public static void main(String[] args) {
        //int[] nums = {0, 1, 0, 3, 12};
        int[] nums = {2, 1, 0, 3, 12};
        moveZeroes2(nums);
        System.out.println(nums);
    }

    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void moveZeroes(int[] nums) {
        int countOfZeroes = 0;
        Map<Integer, Integer> indexes = new HashMap<>();
        for(int i = 0;i < nums.length; i++) {
            if(nums[i] == 0) {
                countOfZeroes++;
            }
            else {
                indexes.put(i,i);
            }
        }

        if(countOfZeroes == 0) {
            return;
        }

        for(Map.Entry<Integer, Integer> entry : indexes.entrySet()) {
            int value = entry.getValue();
            entry.setValue(value - countOfZeroes < 0 ? 0 : value - countOfZeroes);
        }

        for(Map.Entry<Integer, Integer> entry : indexes.entrySet()) {
            int oldIndex = entry.getKey();
            int newIndex = entry.getValue();
            nums[newIndex] = nums[oldIndex];
        }

        int lastIndex = nums.length - 1;
        for(int i = 0; i < countOfZeroes; i++) {
            nums[lastIndex] = 0;
            lastIndex--;
        }


    }
}
