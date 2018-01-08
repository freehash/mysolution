package com.arraysAndStrings;

import java.util.*;

/**
 * Created by hattur on 10/28/17.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        //int nums[] = {3,7,1,2,8,4,5};
        //int nums[] = {-0, 0, 0};
        //int nums[] = {3,0,-2,-1,1,2};
        List<List<Integer>> lists = threeSum(nums, 0);
        System.out.println(lists);

        Triplet t1 = new Triplet(-1,1,0);
        Triplet t2 = new Triplet(0,1,1);
        //System.out.println(t1.equals(t2));
    }

    public static List<List<Integer>> threeSum(int[] nums, int target) {
        Set<Triplet> output = new HashSet<>();
        if(nums.length == 3) {
            if(nums[0] + nums[1] + nums[2] == 0) {
                Triplet triplet = new Triplet(nums[0], nums[1], nums[2]);
                output.add(triplet);
            }
            return decodeTriplet(output);
        }

        for(int i = 0 ; i < nums.length - 3; i++) {
            HashSet<Integer> set = new HashSet<>();
            int num1 = nums[i];
            int difference = target - num1;
            set.add(nums[i+1]);
            for(int j = i+2; j < nums.length; j++) {
                int num2 = nums[j];
                int diff = difference - num2;
                if(set.contains(diff)) {
                   Triplet triplet = new Triplet(num1, num2, diff);
                   output.add(triplet);
                }
                else {
                    set.add(num2);
                }
            }
        }

        return decodeTriplet(output);
    }

    private static List<List<Integer>> decodeTriplet(Set<Triplet> triplets) {
        List<List<Integer>> output = new ArrayList<>();
        for(Triplet triplet : triplets) {
            output.add(Arrays.asList(triplet.getNum1(), triplet.getNum2(), triplet.getNum3()));
        }
        return output;
    }
}

class Triplet {
    private int num1;
    private int num2;
    private int num3;

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getNum3() {
        return num3;
    }

    Triplet(int num1, int num2, int num3) {
        this.num1 = Math.min(num1, Math.min(num2, num3));
        this.num3 = Math.max(num1, Math.max(num2, num3));
        this.num2 = num1 + num2 + num3 - (this.num1 + this.num3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triplet triplet = (Triplet) o;

        if (num1 != triplet.num1) return false;
        if (num2 != triplet.num2) return false;
        return num3 == triplet.num3;
    }

    @Override
    public int hashCode() {
        int result = num1;
        result = 31 * result + num2;
        result = 31 * result + num3;
        return result;
    }
}
