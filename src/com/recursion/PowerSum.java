package com.recursion;

public class PowerSum {
    public static void main(String[] args) {
        System.out.println(powerSum(10, 2, 1));
    }

    private static int powerSum(int remainder, int power, int index) {
        int sum = (int)Math.pow(index, power);
        if(sum > remainder) {
            return 0;
        }
        if(sum == remainder) {
            return 1;
        }
        index ++;
        return powerSum(remainder - sum, power, index) + powerSum(remainder, power, index);
    }
}
