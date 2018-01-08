package com;

/**
 * Created by hattur on 10/14/17.
 */
public class FactorialTrailingZeros {
    public static void main(String[] args) {
        //System.out.println(countFactZeros(10));
        System.out.println(countFactorZeros(10));
    }

    static int factorsOf5(int i) {
        int count = 0;
        while(i % 5 == 0) {
            count ++;
            i /= 5;
        }
        return count;
    }

    static int countFactorZeros(int num) {
        int count = 0;
        for(int i = 2; i <= num; i++) {
            int fact = factorsOf5(i);
            count += fact;
        }
        return count;
    }

    static int countFactZeros(int num) {
        int count= 0;
        for(int i = 5; num/i > 0; i*= 5){
            int temp = num/i;
            count += temp;
        }
        return count;
    }
}
