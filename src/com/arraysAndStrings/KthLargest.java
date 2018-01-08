package com.arraysAndStrings;

import java.util.Arrays;
import java.util.Random;


/**
 * Created by hattur on 10/28/17.
 */
public class KthLargest {
    public static void main(String[] args) {
        int[] nums = {2,2,3,1}; // 1,2,3,4,5,6
        int k = 2;
        int i = 6 - k;
        //int rank = rank(nums, 0, 5, i);
        //System.out.println(rank);
        //System.out.println(getKthLargest(nums, 2));
        System.out.println(thirdMax(nums));
    }

    private static int rank(int[] array, int left, int right, int rank) {
        int pivot = array[randomIntinRange(left, right)];
        int leftEnd = partition(array, left, right, pivot);
        int leftSize = leftEnd - left + 1;
        if(rank == leftSize - 1) {
            return max(array, left, leftEnd);
        }
        else if(rank < leftSize) {
            return rank(array, left, leftEnd, rank);
        }
        else {
            return rank(array, leftEnd+1, right, rank - leftSize);
        }

    }

    private static int max(int[] array, int left, int right) {
        int max = Integer.MIN_VALUE;
        for(int i = left; i <= right; i++) {
            max = Math.max(array[i], max);
        }
        return max;
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        while(left <= right) {
            if(array[left] >= pivot) {
                swap(array, left, right);
                right --;
            }
            else if(array[right] <= pivot) {
                swap(array, left, right);
                left ++;
            }
            else {
                left++;
                right--;
            }
        }
        return left - 1;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    private static int randomIntinRange(int min, int max) {
        Random random = new Random();
        int rand = random.nextInt(max + 1 - min) + min;
        return rand;
    }

    private static int getKthLargest(int[] array, int k) {
        Arrays.sort(array);
        int len = array.length;
        int index = len - k;
        return array[index];
    }

    public static int thirdMax(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if(nums.length == 3) {
            return Math.min(nums[0], Math.min(nums[1], nums[2]));
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;
        boolean allInitialized = false;

        for(int i = 3;i < nums.length; i++) {
            if(!allInitialized && largest != Integer.MIN_VALUE && secondLargest != Integer.MIN_VALUE && thirdLargest != Integer.MIN_VALUE) {
                allInitialized = true;
            }
            if(allInitialized && (nums[i] == largest || nums[i] == secondLargest || nums[i] == thirdLargest)) {
                continue;
            }
            if(nums[i] > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = nums[i];
            }
            else if(nums[i] > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = nums[i];
            }
            else if(nums[i] > thirdLargest) {
                thirdLargest = nums[i];
            }
        }
        return thirdLargest;
    }
}


