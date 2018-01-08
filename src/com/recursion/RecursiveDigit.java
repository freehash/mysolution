package com.recursion;

/**
 * Created by hattur on 10/11/17.
 */
public class RecursiveDigit {

    public static void main(String[] args) {
        //int digit = 148148148;
        int digit = 9875;
        //System.out.println((int)digit%10);
        System.out.println(sum(digit));
    }

    private static int sum(int number) {
        if(number < 10) {
            return number;
        }

        return sum(number % 10 + sum(number/10));
    }
}
