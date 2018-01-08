package com.arraysAndStrings;

/**
 * Created by hattur on 11/6/17.
 */
public class SumSwap {
    public static void main(String[] args) {
        int[] array1 = {4,1,2,1,1,2};
        int[] array2 = {3,6,3,3};

        int[] swapValues = findSwapValues(array1, array2);
        System.out.println(swapValues);
    }
    private static int[] findSwapValues(int[] array1, int[] array2) {
        Integer target = getTarget(array1, array2);
        for(int one : array1) {
            for(int two : array2) {
                if(one - two == target) {
                    int[] values = {one, two};
                    return values;
                }
            }
        }
        return null;
    }

    private static int sum(int[] array) {
        int sum = 0;
        for(int i : array) {
            sum += i;
        }
        return sum;
    }

    private static Integer getTarget(int[] array1, int[] array2) {
        int sum1 = sum(array1);
        int sum2 = sum(array2);
        if((sum1 - sum2) % 2 != 0 ) {
            return null;
        }
        return (sum1 - sum2)/2;
    }
}
