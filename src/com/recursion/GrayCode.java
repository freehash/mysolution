package com.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hattur on 10/29/17.
 */
public class GrayCode {

    public static void main(String[] args) {
        List<Integer> grayCodes = new ArrayList<>();
        generateGrayCode(3, grayCodes);
        System.out.println(grayCodes);


        //System.out.println(twoPower(1));
    }

    static int twoPower(int n) {
        return 1 << n;
    }

    private static void generateGrayCode(int n, List<Integer> grayCodes) {
        if(n == 1) {
            grayCodes.add(0);
            grayCodes.add(1);
        }
        else {
            generateGrayCode(n-1, grayCodes);
            for(int i = grayCodes.size()-1 ; i >=0 ;i --) {
                int sum = twoPower(n-1);
                grayCodes.add(sum+grayCodes.get(i));
            }

        }
    }
}
