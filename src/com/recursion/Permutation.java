package com.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        //List<String> perms = getPerms("abc");
        int[] numbers = {1,2,3};
        List<List<Integer>> perms2 = getPerms2(numbers, 0);
        System.out.println(perms2);
    }

    private static List<String> getPerms(String remainder) {
        int len = remainder.length();
        List<String> result = new ArrayList<>();
        if(len == 0) {
            result.add("");
            return result;
        }

        for(int i=0;i<len;i++) {
            String before = remainder.substring(0,i);
            String after = remainder.substring(i+1,len);
            List<String> partials = getPerms(before + after);

            for(String s : partials) {
                result.add(remainder.charAt(i) + s);
            }
        }
        return result;
    }

    private static List<List<Integer>> getPerms2(int[] numbers, int index) {
        List<List<Integer>> result = new LinkedList<>();
        if(index == numbers.length-1) {
            List<List<Integer>> singleList = new LinkedList<>();
            List<Integer> single = new LinkedList<>();
            single.add(numbers[index]);
            singleList.add(single);
            return singleList;
        }

        List<List<Integer>> perms2 = getPerms2(numbers, index + 1);
        int current = numbers[index];
        for(List<Integer> perms : perms2) {
            for(int i = 0; i <= perms.size(); i++) {
                List<Integer> curPerm = new LinkedList<>(perms);
                curPerm.add(i, current);
                result.add(curPerm);
            }
        }
        return result;
    }

}
