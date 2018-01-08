package com.strings;

import java.util.Arrays;

/**
 * Created by hattur on 10/16/17.
 */
public class Anagram {
    public static void main(String[] args) {
        //System.out.println(isAnagram("harsha", "rsah"));

        int[] a = {1,0,1};
        int[] b = {1,0,1};

        if(Arrays.equals(a,b)) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }

    private static boolean isAnagram(String s, String t) {
        int[] charCount = new int[26];
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            charCount[index]++;
        }

        for(int j = 0; j < t.length(); j++) {
            int index = t.charAt(j) - 'a';
            charCount[index] --;
            if(charCount[index] < 0) {
                return false;
            }
        }

        return true;
    }
}
