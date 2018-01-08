package com.arraysAndStrings;

/**
 * Created by hattur on 11/5/17.
 */
public class SumPlusOne {

    public static void main(String[] args) {
        int[] num = {9,9};
        int[] ints = plusOne(num);
        System.out.println(ints);
    }


    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }
}
