package com.arraysAndStrings;

import java.util.*;

/**
 * Created by hattur on 10/18/17.
 */
public class SmallestDifference {
    public static void main(String[] args) {
        int[] arr = {3, -7, 0, 23, 54, 26};
        List<Integer> smallestPairs = new ArrayList<>();
        System.out.println(minimumAbsoluteDifference(arr.length, arr, smallestPairs));
        System.out.println(smallestPairs);
    }

    private static int minimumAbsoluteDifference(int n, int[] arr, List<Integer> smallestPairs) {
        int difference = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i = 1; i < n; i++) {
            int currentDifference = Math.abs(arr[i] - arr[i-1]);
            if(currentDifference < difference) {
                smallestPairs.clear();
                smallestPairs.add(arr[i-1]);
                smallestPairs.add(arr[i]);
                difference = currentDifference;
            }
            else if (currentDifference == difference) {
                smallestPairs.add(arr[i-1]);
                smallestPairs.add(arr[i]);
            }
        }
        return difference;
    }
}
