package com;

/**
 * Created by hattur on 8/19/17.
 */
public class BitManipulations {
    public static void main(String [] args) {
        int L = 10;
        int R = 15;
        int xored  = L ^ R;
        int significantBit = 31 - Integer.numberOfLeadingZeros(xored);
        int result = (1 << (significantBit + 1)) - 1;

        System.out.println(1 << 3);
        System.out.println(result);
        System.out.println(negate(1000000045));
    }

    private static int negate(int a) {
        int neg = 0;
        int newSign = a < 0 ? 1 : -1;
        while(a != 0) {
            neg += newSign;
            a += newSign;
        }
        return neg;
    }
}
