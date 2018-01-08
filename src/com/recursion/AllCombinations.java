package com.recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hattur on 11/8/17.
 */
public class AllCombinations {

    public static void main(String[] args) {
        String digits = "235";
        ArrayList<Character>[] s = new ArrayList[digits.length()];
        int c = 0;
        for(int i = 0;i < digits.length(); i++) {
            char[] t9Chars = getT9Chars(digits.charAt(i));
            ArrayList<Character> list = new ArrayList<>();
            for(char ch : t9Chars) {
                list.add(ch);
            }
            s[c++] = list;
        }

        List<String> product = cartesianProduct(s);

        System.out.println(product);
    }

    public static List<String> cartesianProduct(List<Character>... sets) {
        List<String> allSets = new ArrayList<>();
        LinkedList<LinkedList<Character>> lists = cartesianProduct(0, sets);
        for(List<Character> list : lists) {
            String res = "";
            for(char s : list) {
                res += s;
            }
            allSets.add(res);
        }
        return allSets;
    }
    private static LinkedList<LinkedList<Character>> cartesianProduct(int index, List<Character>... sets) {
        LinkedList<LinkedList<Character>> ret = new LinkedList<>();
        if (index == sets.length) {
            ret.add(new LinkedList<Character>());
        } else {
            for (char obj : sets[index]) {
                for (LinkedList<Character> set : cartesianProduct(index+1, sets)) {
                    set.addFirst(obj);
                    ret.add(set);
                }
            }
        }
        return ret;
    }

    private static char[] getT9Chars(char digit) {
        if(!Character.isDigit(digit)) {
            return null;
        }
        int dig = Character.getNumericValue(digit) - Character.getNumericValue('0');
        return t9Letters[dig];
    }

    static char[][] t9Letters = {null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j','k','l'}, {'m','n','o'},
            {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};


}
