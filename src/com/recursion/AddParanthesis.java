package com.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hattur on 11/3/17.
 */
public class AddParanthesis {
    public static void main(String[] args) {
        int n = 4;
        char[] str = new char[2*n];
        List<String> result = new ArrayList<>();
        addParen(result, n, n, str, 0);
        System.out.println(result);
    }

    private static void addParen(List<String> result, int leftRemaining, int rightRemaining, char[] str, int index) {
        if(leftRemaining < 0 || rightRemaining < leftRemaining) {
            return ;
        }
        if(leftRemaining == 0 && rightRemaining == 0) {
            result.add(String.copyValueOf(str));
        }
        else {
            str[index] = '(';
            addParen(result, leftRemaining - 1, rightRemaining, str, index + 1);
            str[index] = ')';
            addParen(result, leftRemaining, rightRemaining-1, str, index + 1);
        }
    }
}
