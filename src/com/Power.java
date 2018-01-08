package com;

/**
 * Created by hattur on 10/19/17.
 */
public class Power {
    public static void main(String[] args) {
        System.out.println(myPow(8.88023,3));
        System.out.println(Math.pow(8.88023, 3));

        System.out.println(myPow(10,3));
        System.out.println(Math.pow(10, 3));
    }

    private static double myPow(double x, int n) {
        double pow = 1;
        for(int i = 1; i<= n; i++) {
            pow *= x;
        }
        return pow;
    }
}
