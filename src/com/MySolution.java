package com;


public class MySolution {
    public static void main(String[] args) {
        int x = 61523;
        int y = 10000;
        System.out.println(x % y);
        int roundDown = x - x % y;
        System.out.println(roundDown);
    }
}


