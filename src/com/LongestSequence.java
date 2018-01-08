package com;

/**
 * Created by hattur on 10/14/17.
 */
public class LongestSequence {
    public static void main(String[] args) {
        int[] numbers = {5,-9,6,-2,3};
        System.out.println(findMaxSum(numbers));
    }

    private static int findMaxSum(int[] numbers) {
        int sum = 0;
        int maxSum = 0;

        for(int i = 0;i < numbers.length; i++) {
            sum = sum + numbers[i];
            if(sum < 0) {
                sum = 0;
            }
            if(maxSum < sum) {
                maxSum = sum;
            }
        }

        return maxSum;
    }
}
