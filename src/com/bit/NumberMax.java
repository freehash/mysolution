package com.bit;

/**
 * Created by hattur on 11/6/17.
 */
public class NumberMax {
    public static void main(String[] args) {
        //System.out.println(sign(-2));
        //System.out.println(-2 >> 31);

        System.out.println(-2 >> 31);
        System.out.println(-2 >> 31 & 1);
        System.out.println(0x1);
    }

    private static int sign(int a) {
        //int b = (a >> 31) & 0x1;
        //System.out.println(b);

        return flip((a >> 31) & 0x1);
    }

    private static int flip(int bit) {
        return 1 ^ bit;
    }
}
