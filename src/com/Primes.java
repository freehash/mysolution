package com;

/**
 * Created by hattur on 10/15/17.
 */
public class Primes {
    public static void main(String[] args) {
        boolean[] primes = sieveOfEratothenes(2);
        System.out.println(countPrimes(primes));
    }

    private static int countPrimes(boolean[] primes) {
        int count = 0;
        for(int i = 2; i < primes.length; i++) {
            if(primes[i]) {
                count++;
            }
        }
        return count;
    }

    private static boolean[] sieveOfEratothenes(int number) {
        boolean[] flags = new boolean[number + 1];
        init(flags);
        int prime = 2;
        while(prime < Math.sqrt(number)) {
            crossOff(flags, prime);
            prime = getNextPrime(flags, prime);
        }

        return flags;
    }

    private static void init(boolean[] flags) {
        for(int i = 2;i < flags.length; i++) {
            flags[i] = true;
        }
    }

    private static void crossOff(boolean[] flags, int prime) {
        for(int i = prime * prime; i < flags.length; i = i+prime) {
            flags[i] = false;
        }
    }

    private static int getNextPrime(boolean[] flags, int prime) {
        for(int i = prime+1; i < flags.length; i++) {
            if(flags[i]) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
}
