package com.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hattur on 10/31/17.
 */
public class AllAnagramsInString {
    public static void main(String[] args) {
        String s = "";
        String p = "a";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);
    }
    public static List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int[] patternCount = new int[26];
        int tempCount[] = new int[26];
        for(int i = 0; i < p.length(); i++) {
            patternCount[p.charAt(i) - 'a']++;
            tempCount[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(patternCount, tempCount)) {
            result.add(0);
        }
        //s: "cbaebabacd" p: "abc"
        for(int i = p.length(); i<s.length(); i++){
            tempCount[s.charAt(i-p.length()) - 'a']--;
            tempCount[s.charAt(i) - 'a']++;
            if(Arrays.equals(patternCount, tempCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
