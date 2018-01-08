package com.arraysAndStrings;

/**
 * Created by hattur on 11/11/17.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"leets", "leetcode", "leet", "leeds"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
