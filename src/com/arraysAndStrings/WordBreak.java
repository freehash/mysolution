package com.arraysAndStrings;

import java.util.*;

/**
 * Created by hattur on 10/14/17.
 */
public class WordBreak {

    public static void main(String[] args) {

       /* String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        //String s = "abcd";
        List<String> dict = new ArrayList<>();
        dict.add("aa");
        dict.add("aaa");
        dict.add("aaaa");
        dict.add("aaaaa");
        dict.add("aaaaaa");
        dict.add("aaaaaaa");
        dict.add("aaaaaaaa");
        dict.add("aaaaaaaaa");
        dict.add("aaaaaaaaaa");
        dict.add("ba");*/

       String s = "goalspecial";

        List<String> dict = new ArrayList<>();
        dict.add("go");
        dict.add("goal");
        dict.add("goals");
        dict.add("special");


        Map<String, Boolean> validMap = new HashMap<>();
        //System.out.println(validMap.get("abc"));
        System.out.println(isValid(s, new HashSet<>(dict), new HashMap<String, Boolean>()));
        //System.out.println(word_Break(s, new HashSet<>(dict), 0));
    }

    static boolean isValid(String s, Set<String> dict, Map<String, Boolean> memo) {
        if(dict.contains(s)) {
            return true;
        }
        for(int i = 1; i < s.length(); i++) {
            String left = s.substring(0,i);
            String right = s.substring(i);
            if(dict.contains(left)) {
                if(memo.containsKey(right)) {
                    if(memo.get(right)) {
                        return true;
                    }
                }
                else {
                    boolean isRightValid = isValid(right, dict, memo);
                    memo.put(right, isRightValid);
                    if(isRightValid) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean isValid(String s, Set<String> dict) {
        if(dict.contains(s)) {
            return true;
        }
        for(int i = 1; i < s.length(); i++) {
            String left = s.substring(0,i);
            String right = s.substring(i);
            if(dict.contains(left) && isValid(right, dict)) {
                return true;
            }
        }
        return false;
    }

    public static boolean word_Break(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }
}
